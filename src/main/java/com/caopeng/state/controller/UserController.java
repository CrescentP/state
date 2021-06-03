package com.caopeng.state.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caopeng.state.entity.User;
import com.caopeng.state.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Crescent_P
 * @date 2021-05-23 18:42
 *
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 根据账号和姓名得到用户
     * @author Crescent_P
     * @date 2021-05-24 14:50:08 
     * @param user
     * @return 
     **/
    
    public User getUserByNameAndPassword(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("userName",user.getUserName());
        wrapper.eq("password",user.getPassword());
        return userService.getOne(wrapper);
    }

    /**
     * 根据用户名得到用户
     * @author Crescent_P
     * @date 2021-05-24 14:50:35 
     * @param userName
     * @return
     **/
    
    @RequestMapping("/getUserByUserName")
    @ResponseBody
    public Boolean getUserByName(String userName) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("userName",userName);
//        System.out.println(userService.getOne(wrapper));
        User user = userService.getOne(wrapper);
        if (user == null) return true;
        else return false;
    }

    /**
     * 
     * @author 登录
     * @date 2021-05-24 14:51:00 
    * @param user
     * @return
     **/
    @RequestMapping("/goLogin")
    public String login(User user, HttpSession session, Model model){
        System.out.println("Debug==>User" + user);

        if(getUserByNameAndPassword(user) != null) {
            // 登录时候有Session
            session.setAttribute("userSession", user);
            System.out.println("用户界面登录成功");
            return "redirect:index";
        }
        else {
            model.addAttribute("msg","账号或密码错误");
            return "Login";
        }
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println(user);
        boolean flag = userService.save(user);
        System.out.println("Debug==>flag" + flag);
        if(flag) return "redirect:goLogin";
        else return "error";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("Debug=>" + id);
        boolean flag = userService.removeById(id);
        return "redirect:/admin/user";
    }


}
