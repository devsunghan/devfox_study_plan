package com.jojoldu.spring;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing // 배치기능 할성화
@SpringBootApplication
public class BatchProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchProjectApplication.class, args);
    }

}
