package com.example.point.config;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
public enum Code {

    //COMMON
    SUCCESS("CM_0001", "성공하였습니다.", HttpStatus.OK),
    BAD_REQUEST("CM_0002", "잘못된 요청입니다.", HttpStatus.BAD_REQUEST),
    SERVER_ERROR("CM_0003", "서버 에러입니다. 관리자에게 문의하세요.", HttpStatus.INTERNAL_SERVER_ERROR),

    //Account
    ACCOUNT_NOT_FOUND("AC_0001", "해당 회원을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST),;

    private final String code;
    private String message;
    private HttpStatus status;

    Code(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    @JsonValue
    public String getCode() {
        return this.code;
    }

}


