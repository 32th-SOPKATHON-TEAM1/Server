package com.sopt.sopkaton.exception.model;

import com.sopt.sopkaton.exception.Error;
public class ServerErrorException extends SoptException{

    public ServerErrorException(Error error, String message) {
        super(error, message);
    }
}
