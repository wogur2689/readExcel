package com.example.readexcel.enums;

import lombok.Getter;

@Getter
public enum CommonCode {
    /**
     * api 통신 코드
     * 0000 ~ 9999
     */
    CODE_0000("0000", "성공"),
    CODE_0001("0001", "지원 불가능"),
    CODE_0002("0002", "네트워크 에러"),
    CODE_0003("0003", "시스템 에러"),
    CODE_0004("0004", "기타 에러");

    private final String code;
    private final String msg;

    CommonCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg(String code) {
        if(code == null) {
            return "해당 코드는 없는 코드입니다.";
        }
        for(CommonCode codeValue : values()) {
            if(codeValue.getCode().equals(code)) {
                return codeValue.getMsg();
            }
        }
        return "해당 코드는 없는 코드입니다.";
    }
}
