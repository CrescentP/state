package com.caopeng.state.service.plan;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caopeng.state.entity.Plan;
import com.caopeng.state.entity.State;
import com.caopeng.state.mapper.PlanMapper;
import com.caopeng.state.mapper.StateMapper;
import com.caopeng.state.service.state.StateService;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl extends ServiceImpl<PlanMapper, Plan> implements PlanService {
}
