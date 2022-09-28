package com.example.mapstruct_taya.service;

import com.example.mapstruct_taya.dto.product.ProductAction;
import com.example.mapstruct_taya.dto.product.ProductRequest;
import com.example.mapstruct_taya.dto.product.ProductResponse;

public interface ProductActionProcessor {
    ProductResponse process(final String fingerprint, final ProductRequest request);
    ProductAction action();
}
