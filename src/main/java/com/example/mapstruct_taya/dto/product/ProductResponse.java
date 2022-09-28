package com.example.mapstruct_taya.dto.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {
    private boolean success = true;
    private ProductResponseData data;

    private List<MessageInfo> warnings = new ArrayList<>();
    private List<MessageInfo> errors = new ArrayList<>();

    public ProductResponse addWarning(final int code, final String message) {
        warnings.add(new MessageInfo(code, message));
        return this;
    }

    public ProductResponse addError(final int code, final String message) {
        errors.add(new MessageInfo(code, message));
        return this;
    }

    @Data
    @AllArgsConstructor
    public static class MessageInfo {
        private int code;
        private String message;
    }
}
