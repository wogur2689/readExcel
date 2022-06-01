package com.example.readexcel.enums;

import lombok.Getter;

@Getter
public enum Cook {
    /**
     * (요리) 공통 코드 정의서
     * 한식 - 분식, 고기, 비빔밥, 찌개, 국, 전 등
     * 일식 - 초밥, 카츠, 라멘 등
     * 중식 - 양꼬치, 짜장면, 짬뽕, 마라탕 등
     * 양식 - 스테이크, 파스타, 햄버거, 치킨, 피자 등
     * 디저트 - 음료, 샌드위치, 쿠키, 커피 등
     * 기타 - 쌀국수, 팟타이, 우육탕면, 커리, 케밥 등
     */
    KOREA("한식"),
    JAPAN("일식"),
    CHINESE("중식"),
    WESTERN("양식"),
    DESSERT("디저트"),
    ETC("기타");

    private final String code;

    Cook(String code) { this.code = code; }
}
