package com.example.mapstruct_taya.validator;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiErrorResponse extends ApiDefaultResponse implements Serializable {
    private String errorCause;

    private ApiErrorResponse(int code, String errorMsg) {
        super(code);
        this.errorCause = errorMsg;
    }

    public static ApiErrorResponse valueOf(int code, String errorMsg) {
        return new ApiErrorResponse(code, errorMsg);
    }

    public String toString() {
        return "ApiErrorResponse(errorCause=" + this.getErrorCause() + ")";
    }
}
