package com.persion.study.sharding;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 彭心潮
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.persion.study"})
@MapperScan("com.persion.study.sharding.dao.mapper")
public class ShardingJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcApplication.class, args);
    }
}