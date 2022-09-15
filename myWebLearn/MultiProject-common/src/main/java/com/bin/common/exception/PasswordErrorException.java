package com.bin.common.exception;

import org.springframework.security.authentication.BadCredentialsException;

public class PasswordErrorException extends BadCredentialsException {

    private String msg;

    public PasswordErrorException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return msg;
    }
}
