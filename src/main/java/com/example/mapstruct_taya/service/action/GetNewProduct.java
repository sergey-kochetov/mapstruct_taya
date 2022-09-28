package com.example.mapstruct_taya.service.action;

import com.example.mapstruct_taya.dto.product.ProductAction;
import com.example.mapstruct_taya.dto.product.ProductRequest;
import com.example.mapstruct_taya.dto.product.ProductResponse;
import com.example.mapstruct_taya.service.ProductActionProcessor;
import org.springframework.stereotype.Component;

@Component
public class GetNewProduct implements ProductActionProcessor {
    @Override
    public ProductResponse process(String fingerprint, ProductRequest request) {
        return null;
    }

    @Override
    public ProductAction action() {
        return ProductAction.GET_NEW_EMPTY_PRODUCT;
    }
}
