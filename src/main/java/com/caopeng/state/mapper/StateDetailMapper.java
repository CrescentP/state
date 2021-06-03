package com.caopeng.state.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caopeng.state.entity.State;
import com.caopeng.state.entity.StateDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

// 在对应的Mapper上继承基本的接口 BaseMapper
// 继承了 BaseMapper 所有的方法都来自父类
// 我们也可以编写自己的扩展方法
@Repository
@Mapper
public interface StateDetailMapper extends BaseMapper<StateDetail> {
}
