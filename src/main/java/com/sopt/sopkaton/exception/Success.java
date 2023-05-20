package com.sopt.sopkaton.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Success {

    /**
     * 200 SUCCESS
     */
    ASSERT_SUCCESS(HttpStatus.OK, "포스터 조회 성공입니다."),
    PRODUCT_SUCCESS(HttpStatus.OK, "포스터 등록 성공입니다.");

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
