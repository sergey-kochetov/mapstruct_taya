package com.example.mapstruct_taya.mapper;

import com.example.mapstruct_taya.dto.ProductDto;
import com.example.mapstruct_taya.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(imports = {UUID.class})
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "product.desc", target = "description", defaultValue = "description")
    @Mapping(target = "epicId", expression = "java(UUID.randomUUID().toString())")
    ProductDto toDto(Product product);

    @Mapping(source = "productDto.description", target = "desc", defaultValue = "description")
    Product fromDto(ProductDto productDto);
}
