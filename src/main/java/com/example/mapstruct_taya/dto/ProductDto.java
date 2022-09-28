package com.example.mapstruct_taya.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(chain = true)
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private BigDecimal price;
    private String epicId;
}
