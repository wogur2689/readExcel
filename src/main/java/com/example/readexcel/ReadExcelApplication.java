package com.example.readexcel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ReadExcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadExcelApplication.class, args);
    }

}
