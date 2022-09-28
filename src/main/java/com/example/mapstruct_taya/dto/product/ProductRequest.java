package com.example.mapstruct_taya.dto.product;

import com.example.mapstruct_taya.deserializer.ProductRequestDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@JsonDeserialize(using = ProductRequestDeserializer.class)
public class ProductRequest {
    @NotBlank
    private String user;
    @NotBlank
    private String pass;
    @NotNull
    private ProductAction action;
    private ProductRequestData data;

}
