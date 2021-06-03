package com.caopeng.state.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

public class MybatisPlusConfig {

    // 分页组件
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
