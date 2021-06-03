package com.caopeng.state.service.detail;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caopeng.state.entity.State;
import com.caopeng.state.entity.StateDetail;
import com.caopeng.state.mapper.StateDetailMapper;
import com.caopeng.state.mapper.StateMapper;
import com.caopeng.state.service.state.StateService;
import org.springframework.stereotype.Service;

@Service
public class StateServiceDetailImpl extends ServiceImpl<StateDetailMapper, StateDetail> implements StateDetailService {
}
