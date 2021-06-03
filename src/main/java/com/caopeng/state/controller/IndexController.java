package com.caopeng.state.controller;

import com.caopeng.state.entity.State;
import com.caopeng.state.service.state.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private StateService stateService;

    /**
     * 跳转首页
     * @return
     */
    @GetMapping("/index")
    public String index(Model model){
        List<State> states = stateService.list(null);
        model.addAttribute("states",states);
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "Login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

}
