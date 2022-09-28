package com.example.mapstruct_taya.mapper;

import com.example.mapstruct_taya.dto.ItemDto;
import com.example.mapstruct_taya.dto.ProductDto;
import com.example.mapstruct_taya.model.Item;
import com.example.mapstruct_taya.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "product.items", expression = "java(toDto(product.getItems())")
    ProductDto toDto(Product product);

    @Mapping(target = "productDto.items", expression = "java(fromDto(productDto.getItems()))")
    @Mapping(target = "epicId", expression = "java(UUID.randomUUID().toString())")
    Product fromDto(ProductDto productDto);

    ItemDto toDto(Item item);

    @Mapping(target = "product", ignore = true)
    Item fromDto(ItemDto itemDto);

    List<ProductDto> toDtos(List<Product> products);
}
