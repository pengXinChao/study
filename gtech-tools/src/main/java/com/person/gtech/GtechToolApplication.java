package com.person.gtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 彭心潮
 * @date 2022/11/6 20:48
 */
@SpringBootApplication
@MapperScan("com.person.gtech.dao.mapper")
@ComponentScan(basePackages = {"com.person", "com.gtech"})
public class GtechToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(GtechToolApplication.class, args);
    }

}
