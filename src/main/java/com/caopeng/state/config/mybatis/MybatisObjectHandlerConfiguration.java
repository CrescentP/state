package com.caopeng.state.config.mybatis;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class MybatisObjectHandlerConfiguration {

    @Bean
    public MetaObjectHandler mateObjectHandler(){
        // 内部类
        return new MetaObjectHandler(){
            @Override
            public void insertFill(MetaObject metaObject) {
                this.setFieldValByName("create_Time",new Date(),metaObject);
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                this.setFieldValByName("update_time",new Date(),metaObject);
            }
        };
    }

}
