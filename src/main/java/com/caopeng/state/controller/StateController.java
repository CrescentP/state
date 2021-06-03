package com.caopeng.state.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.caopeng.state.entity.Plan;
import com.caopeng.state.entity.State;
import com.caopeng.state.entity.StateDetail;
import com.caopeng.state.service.detail.StateDetailService;
import com.caopeng.state.service.plan.PlanService;
import com.caopeng.state.service.state.StateService;
import com.caopeng.state.service.state.StateServiceImpl;
import com.caopeng.state.vo.R;
import com.caopeng.state.vo.StateVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

//@RestController

@Controller
public class StateController {

    @Autowired
    private StateService stateService;
    @Autowired
    private StateDetailService stateDetailService;
    @Autowired
    private PlanService planService;

    /**
     *
     * @author Crescent_P
     * @date 2021-05-23 13:48:52
     * @param id
     * @return 根据id跳转到指定的明细页面
     **/
    @GetMapping("/state/{id}")
    public String findStates(@PathVariable("id") Integer id, ModelMap modelMap){
        // 1. 根据id查询统计页面是否存在
        State state = stateService.getById(id);
        if(state != null){
            // 2. 如果存在 就进入页面
            modelMap.put("id", id);
            return "state/detail";
        }
        // 不存在则进入到错误页面
        return "redirect:/error";
    }


    /**
     *  根据stateId查询统计明细
     * @author Crescent_P
     * @date 2021-05-23 13:59:29
     * @param stateId
     * @return
     **/
    @GetMapping("/state/detail")
    @ResponseBody
    public R getStateDetail(Integer stateId){
        if(StringUtils.isEmpty(stateId)) return R.error().code(601).message("没有找到对应的主题");
        // 1. 通过id查询统计
        State state = stateService.getById(stateId);
        System.out.println(state);
        if(StringUtils.isEmpty(state)) return R.error().code(601).message("没有找到对应的主题");
        // 2. 根据id查询统计明细
        QueryWrapper<StateDetail> wrapper = new QueryWrapper<>();
        wrapper.eq("stateId",stateId);
        List<StateDetail> stateDetails = stateDetailService.list(wrapper);
        // 3.把state对象和stateDetail组装到vo对象中
        StateVo stateVo = new StateVo();
        System.out.println(stateVo);
        BeanUtils.copyProperties(state,stateVo);
        System.out.println(stateVo);
        stateVo.setStateDetailList(stateDetails);
        // 4.然后用vo把R统一返回
        return R.ok().data("stateVo",stateVo);
    }

    /**
     *
     * @author Crescent_P
     * @date 2021-05-24 14:09:53
     * @param state
     * @param details
     * @return 保存统计表
     **/

    @RequestMapping("/admin/saveStateVo")
    public String saveState(State state,@RequestParam("stateDetailList") String[] details){
//        System.out.println(state);
//        for (String detail : details) {
//            System.out.println(detail);
//        }
        // 保存统计
        stateService.save(state);
        // 保存统计明细
        // 先获取是哪几项
        for (String i : details) {
            Plan plan = planService.getById(i);
            StateDetail stateDetail = new StateDetail();
            // 设置title
            stateDetail.setTitle(plan.getName());
            // 设置是哪个 统计表的
            QueryWrapper<State> wrapper = new QueryWrapper<>();
            wrapper.eq("title",state.getTitle());
            wrapper.eq("description",state.getDescription());
            stateDetail.setStateid(stateService.getOne(wrapper).getId());
            stateDetail.setItemNum(0);
            stateDetailService.save(stateDetail);
        }
        return "redirect:table";
    }






//    @GetMapping("/state/list")
//    public R findStates(){
//        // 1.设置条件
//        QueryWrapper<State> wrapper = new QueryWrapper<>();
//        List<State> list = stateService.list(wrapper);
//        return R.ok().data("stateList",list);
////        return list;
//    }
//
//    @GetMapping("/state/saveupdate")
//    public R saveState(){
//        State state = new State();
//        state.setTitle("xxxxx");
//        state.setId(2);
//        boolean flag = stateService.saveOrUpdate(state);
//
//        return flag ? R.ok() : R.error();
//    }
}
