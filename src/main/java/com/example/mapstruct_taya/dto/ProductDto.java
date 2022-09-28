package com.example.mapstruct_taya.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ProductDto implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private BigDecimal price;
    private String epicId;
    private List<ItemDto> items = new ArrayList<>();
}
