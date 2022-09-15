package com.bin.common.exception;

/**
 * @ClassName:
 * @Description:
 * @Author: BIN
 * @Date: 2022/5/15 18:30
 */
public class TokenNotFoundException extends Exception{

    private String message;

    public TokenNotFoundException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return message;
    }
}
