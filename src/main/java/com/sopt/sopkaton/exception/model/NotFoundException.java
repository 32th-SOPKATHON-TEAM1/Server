package com.sopt.sopkaton.exception.model;

import com.sopt.sopkaton.exception.Error;
public class NotFoundException extends SoptException{

    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}
