package com.example.mapstruct_taya.controller;

import com.example.mapstruct_taya.dto.ProductDto;
import com.example.mapstruct_taya.mapper.ProductMapper;
import com.example.mapstruct_taya.model.Product;
import com.example.mapstruct_taya.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @GetMapping("/new")
    public ProductDto getNewProductForSave() {
        return new ProductDto()
                .setDescription("empty")
                .setName("default-name")
                .setQuantity(0)
                .setPrice(BigDecimal.ZERO);
    }

    @PostMapping("/new")
    public ProductDto save(@RequestBody final ProductDto productDto) {
        final Product product = productMapper.fromDto(productDto);
        final Product save = productRepository.save(product);
        return productMapper.toDto(save);
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return productMapper.toDtos(productRepository.findAll());
    }
}
