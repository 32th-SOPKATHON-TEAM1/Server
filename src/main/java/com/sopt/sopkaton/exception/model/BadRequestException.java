package com.sopt.sopkaton.exception.model;

import com.sopt.sopkaton.exception.Error;
public class BadRequestException extends SoptException{

    public BadRequestException(Error error, String message) {
        super(error, message);
    }
}
