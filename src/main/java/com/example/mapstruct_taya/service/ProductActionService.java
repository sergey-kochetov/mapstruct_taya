package com.example.mapstruct_taya.service;

import com.example.mapstruct_taya.dto.product.ProductAction;
import com.example.mapstruct_taya.dto.product.ProductRequest;
import com.example.mapstruct_taya.dto.product.ProductResponse;
import com.example.mapstruct_taya.validator.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductActionService {
    private final Map<ProductAction, ProductActionProcessor> processors;

    public ProductActionService(List<ProductActionProcessor> processors) {
        this.processors = processors.stream()
                .collect(Collectors.toMap(x -> x.action(), y -> y));
    }

    public ProductResponse process(String fingerprint, ProductRequest request) {
        try {
           return Optional.ofNullable(processors.get(request.getAction()))
                    .orElseThrow(() ->  {
                        log.error("Unsupported action: {}", request.getAction());
                        throw new ApplicationException(1004, "Unsupported action : " + request.getAction());
                    }).process(fingerprint, request);
        } catch (ApplicationException ex) {
            log.error("Application error", ex);
            return new ProductResponse()
                    .setSuccess(false)
                    .addError(ex.getErrorCode(), ex.getMessage());
        } catch (Exception ex) {
            log.error("Unexpected error", ex);
            return new ProductResponse()
                    .setSuccess(false)
                    .addError(1000, ex.getMessage());
        }
    }
}
