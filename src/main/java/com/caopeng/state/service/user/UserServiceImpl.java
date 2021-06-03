package com.caopeng.state.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caopeng.state.entity.State;
import com.caopeng.state.entity.User;
import com.caopeng.state.mapper.StateMapper;
import com.caopeng.state.mapper.UserMapper;
import com.caopeng.state.service.state.StateService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
