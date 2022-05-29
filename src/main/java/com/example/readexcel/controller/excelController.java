package com.example.readexcel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/api")
public class excelController {

    @GetMapping("/ping")
    public void Test() {
        log.info("ping~!");
    }
}
