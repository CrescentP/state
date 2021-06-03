package com.caopeng.state.controller;/**
 * @author Crescent_P
 * @date 2021-05-23 20:26
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caopeng.state.entity.State;
import com.caopeng.state.entity.User;
import com.caopeng.state.service.state.StateService;
import com.caopeng.state.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Crescent_P
 * @date 2021-05-23 20:26
 *
 */

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    StateService stateService;

    @RequestMapping("/admin/index")
    public String toIndex(){
        return "admin/index";
    }

    @RequestMapping("/admin/user")
    public String toUser(Model model){
        List<User> users = userService.list(null);
        model.addAttribute("users", users);
        return "admin/User";
    }

    @RequestMapping("/admin/table")
    public String toTable(Model model){
        List<State> states = stateService.list(null);
        model.addAttribute("states", states);
        return "admin/table";
    }

    @RequestMapping("/admin/login")
    public String toLogin(){
        return "admin/Login";
    }

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
     * 管理员登录界面
     * @author Crescent_P
     * @date 2021-05-25 08:05:10
     * @param user
     * @param session
     * @return
     **/

    @RequestMapping("/admin/goLogin")
    public String login(User user, HttpSession session){
        System.out.println("AdminController Debug==>root" + user);
        if(getUserByNameAndPassword(user) != null) {
            // 管理员Session
            if(user.getUserName().equals("Crescent_P")){
                session.setAttribute("rootSession", user);
            }
            session.setAttribute("userSession", user);
            System.out.println("管理员登录成功");
            return "redirect:/admin/index";
        }
        else return "admin/Login";
    }


}
