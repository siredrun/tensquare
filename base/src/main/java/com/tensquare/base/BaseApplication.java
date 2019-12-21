package com.tensquare.base;

import com.tensquare.common.entity.Result;
import com.tensquare.common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName BaseApplication
 * @Author Administrator
 * @Date 2019/12/21 11:52
 * @Deacription 启动类
 **/

@SpringBootApplication
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }

    @Bean
    public Result result() {
        return new Result();
    }
}
