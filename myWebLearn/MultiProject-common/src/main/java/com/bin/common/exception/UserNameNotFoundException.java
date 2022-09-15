package com.bin.common.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserNameNotFoundException extends UsernameNotFoundException {

    private String msg;

    public UserNameNotFoundException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return msg;
    }
}
