package com.caopeng.state.controller;/**
 * @author Crescent_P
 * @date 2021-05-24 15:55
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caopeng.state.entity.State;
import com.caopeng.state.entity.StateDetail;
import com.caopeng.state.service.detail.StateDetailService;
import com.caopeng.state.service.plan.PlanService;
import com.caopeng.state.service.state.StateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Crescent_P
 * @date 2021-05-24 15:55
 *
 */
@Controller
public class VoteController {

    @Autowired
    StateService stateService;
    @Autowired
    StateDetailService stateDetailService;
    @Autowired
    PlanService planService;

    @RequestMapping("/toVote/{id}")
    public String toVote(@PathVariable("id") Integer id, Model model, HttpSession httpSession){
        System.out.println("Debug==>"+id);
        QueryWrapper<StateDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("stateid", id);
        // 得到对应的 details
        List<StateDetail> details = stateDetailService.list(wrapper);
        // 在前端页面展示
        model.addAttribute("details", details);
        httpSession.setAttribute("id",id);
        return "vote";
    }

    @RequestMapping("/addVote")
//    @ResponseBody
    public String toVote(@RequestParam("stateDetailList") String[] details,HttpSession httpSession){
        // 得到对应的 选项 并对其选项加一
        for (String id : details) {
            StateDetail stateDetail = stateDetailService.getById(id);
            stateDetail.setItemNum(stateDetail.getItemNum()+1);
            stateDetailService.updateById(stateDetail);
        }
        Integer id = (Integer) httpSession.getAttribute("id");
//        System.out.println("Debug==>" + id);
        State state = stateService.getById(id);
        state.setPersonNum(state.getPersonNum()+1);
        stateService.updateById(state);

        return "redirect:/state/" +id;
    }


}
