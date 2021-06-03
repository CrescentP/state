package com.caopeng.state;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.caopeng.state.mapper")
public class StateApplication {

    public static void main(String[] args) {
        SpringApplication.run(StateApplication.class, args);
    }

}
