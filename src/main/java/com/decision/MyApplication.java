package com.decision;

import com.decision.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author zhuoshengqi
 * @date 2019/04/03  9:40
 * @description
 */
@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class);
    }

    @Bean
    public IdWorker getId(){
        return new IdWorker();
    }
}
