package com.caopeng.state.controller;/**
 * @author Crescent_P
 * @date 2021-05-24 10:02
 */

import com.caopeng.state.service.state.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Crescent_P
 * @date 2021-05-24 10:02
 *
 */
@Controller
public class TableController {

    @Autowired
    StateService stateService;

    @RequestMapping("/admin/deleteTable/{id}")
    public String deleteTable(@PathVariable("id") Integer id){
        boolean flag = stateService.removeById(id);
        return "redirect:/admin/table";
    }

}
