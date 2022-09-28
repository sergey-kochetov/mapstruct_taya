package com.example.mapstruct_taya.validator;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiDefaultResponse implements Serializable {
    private int errorCode = 0;

    public ApiDefaultResponse(Integer code) {
        this.errorCode = code;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String toString() {
        return "ApiDefaultResponse(errorCode=" + this.getErrorCode() + ")";
    }

    public ApiDefaultResponse() {
    }
}
