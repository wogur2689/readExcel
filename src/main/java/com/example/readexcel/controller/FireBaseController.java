package com.example.readexcel.controller;

import com.example.readexcel.service.FireBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/v1/api")
public class FireBaseController {

    @Resource
    private FireBaseService fireBaseService;

    @GetMapping("/firebase/FoodAndPlay/{value}")
    public ResponseEntity fireBaseData(@PathVariable String value) throws Exception {
        log.info("요청하신 {}번 작업을 시작합니다. 1 - 저장, 2 - 조회, 3 - 삭제.", value);

        switch (value) {
            case "1":
                fireBaseService.insertData();
                break;
            case "2":
                fireBaseService.selectData();
                break;
            default:
                log.error("요청하신 작업은 진행이 불가능합니다. {}", value);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
