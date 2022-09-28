package com.example.mapstruct_taya.validator;

import org.springframework.http.HttpStatus;

public class AuthenticationException  extends ApplicationException{
    public AuthenticationException(String message, Throwable cause) {
        this(1016, message, cause);
    }

    public AuthenticationException(int errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public AuthenticationException(String message) {
        this(1016, message);
    }

    public AuthenticationException(int errorCode, String message) {
        super(errorCode, message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
