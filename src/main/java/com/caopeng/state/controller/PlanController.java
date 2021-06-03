package com.caopeng.state.controller;/**
 * @author Crescent_P
 * @date 2021-05-24 10:38
 */

import com.caopeng.state.entity.Plan;
import com.caopeng.state.service.plan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 * @author Crescent_P
 * @date 2021-05-24 10:38
 *
 */
@Controller
public class PlanController {

    @Autowired
    PlanService planService;

//    @RequestMapping("/admin/getPlanList")
//    public String getPlanList(Model model){
//        List<Plan> planList = planService.list(null);
////        for (Plan plan : planList) {
////            System.out.println(plan);
////        }
//        model.addAttribute("planList",planList);
//        return "admin/addTable";
//    }

    @RequestMapping("/admin/AddTable")
    public String toAddTable(Model model){
        List<Plan> planList = planService.list(null);
        model.addAttribute("planList",planList);
        return "admin/addTable";
    }
}
