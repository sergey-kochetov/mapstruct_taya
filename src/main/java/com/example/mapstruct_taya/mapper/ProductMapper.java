package com.example.mapstruct_taya.mapper;

import com.example.mapstruct_taya.dto.ProductDto;
import com.example.mapstruct_taya.model.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductDto toDto(Product product);
    Product fromDto(ProductDto productDto);
}
