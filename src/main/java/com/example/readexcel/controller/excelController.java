package com.example.readexcel.controller;

import com.example.readexcel.enums.ParamCode;
import com.example.readexcel.service.excelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    /* 데이터 저장 */
    @GetMapping("/{value}")
    public void Menu(@RequestParam String param) {

        //주석 추가 2023-08-06




        //해당 값에 따른 데이터 저장
        if(param.equals(ParamCode.CODE_MENU.getCode())) excelService.menuData(); //메뉴
        if(param.equals(ParamCode.CODE_RESTAURANT.getCode())) excelService.restaurantData(); //레스토랑
        if(param.equals(ParamCode.CODE_FOODANDPLAY.getCode())) excelService.foodAndPlayData(); //먹거리 & 놀거리
        if(param.equals(ParamCode.CODE_FOODANDPLAYDETAIL.getCode())) excelService.foodAndPlayDetailData(); //먹거리 & 놀거리 상세
        //if(param.equals(ParamCode.CODE_SCHOOLTIP.getCode())) excelService.menuData(); //꿀팁
    }

}
