package com.example.readexcel.controller;

import com.example.readexcel.service.excelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Slf4j
@Controller
@RequestMapping("/api")
public class excelController {

    @Resource
    private excelService excelService;

    /* 핑 테스트 */
    @GetMapping("/ping")
    public void Test() {
        log.info("ping~!");
    }

    /* 메뉴 데이터 저장 */
    @GetMapping("/menu")
    public void Menu() {
        try {
            excelService.menuData();
            log.info("메뉴 저장완료!");
        } catch (Exception e) {
            log.error("### 오류발생 : {} ###", e);
        }
    }

    /* 레스토랑 데이터 저장 */
    @GetMapping("/restaurant")
    public void RestaurantData() {
        try {
            excelService.restaurantData();
            log.info("레스토랑 저장완료!");
        } catch (Exception e) {
            log.error("### 오류발생 : {} ###", e);
        }
    }

}
