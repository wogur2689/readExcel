package com.example.readexcel.enums;

import lombok.Getter;

@Getter
public enum ParamCode {
    /**
     * api param 코드
     * menu : 메뉴
     * restaurant : 레스토랑
     * foodAndPlay : 먹기리 & 놀거리
     * schoolTip : 꿀팁
     */
    CODE_MENU("menu"),
    CODE_RESTAURANT("restaurant"),
    CODE_FOODANDPLAY("foodandplay"),
    CODE_FOODANDPLAYDETAIL("foodandplayDetail"),
    CODE_SCHOOLTIP("schooltip"),
    CODE_JINAN("jinan"),
    CODE_JINAN_JDBC("jinan_jdbc");

    private String code;

    ParamCode(String code) { this.code = code; }
}
