package com.example.mapstruct_taya.dto.product;

import com.example.mapstruct_taya.validator.ApplicationException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
public enum ProductAction {
    GET_NEW_EMPTY_PRODUCT("get-new-empty-product", null),
    GET_NEW_EMPTY_ITEM("get-new-empty-item", null),
    SAVE("save", null);

    private final String code;
    private final Class<? extends ProductRequestData> requestDataClass;

    public static ProductAction of(final String action) {
        return Arrays.stream(ProductAction.values())
                .filter(value -> Objects.equals(value.getCode().toLowerCase(), action.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new ApplicationException(1000, "Unsupported action :: " + action));
    }

}
