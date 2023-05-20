package com.sopt.sopkaton.common;

import com.sopt.sopkaton.exception.model.SoptException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionAdvice {
    /**
     * Sopt custom error
     */
    @ExceptionHandler(SoptException.class)
    protected ResponseEntity<ApiResponse> handleSoptException(SoptException e) {
        return ResponseEntity.status(e.getHttpStatus())
                .body(ApiResponse.error(e.getError(), e.getMessage()));
    }
}
