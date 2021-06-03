package com.caopeng.state.service.state;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caopeng.state.entity.State;
import com.caopeng.state.mapper.StateMapper;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl extends ServiceImpl<StateMapper,State> implements StateService {
}
