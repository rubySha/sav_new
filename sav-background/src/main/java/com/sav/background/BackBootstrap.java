package com.sav.background;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by kaikai on 2018/1/20.
 */
@SpringBootApplication
@MapperScan("com.sav.background.mapper")
public class BackBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(BackBootstrap.class);
    }

}
