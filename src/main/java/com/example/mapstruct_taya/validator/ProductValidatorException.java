package com.example.mapstruct_taya.validator;

import org.springframework.http.HttpStatus;

public class ProductValidatorException extends ApplicationException {
    public ProductValidatorException(int errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public ProductValidatorException(int errorCode, String message) {
        super(errorCode, message);
    }

    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
