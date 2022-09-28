package com.example.mapstruct_taya.controller;

import com.example.mapstruct_taya.dto.ItemDto;
import com.example.mapstruct_taya.dto.ProductDto;
import com.example.mapstruct_taya.mapper.ProductMapper;
import com.example.mapstruct_taya.model.Item;
import com.example.mapstruct_taya.model.Product;
import com.example.mapstruct_taya.repository.ProductRepository;
import com.example.mapstruct_taya.service.ProductService;
import com.example.mapstruct_taya.validator.DataNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController("/product")
@AllArgsConstructor
@Transactional(propagation = Propagation.NEVER)
public class ProductController {
    private final ProductMapper productMapper;
    private final ProductRepository productRepository;
    private final ProductService productService;

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

    @GetMapping("/item/new")
    public ItemDto getNewItemForSave() {
        return new ItemDto()
                .setName("n/a");
    }

    @PostMapping("/{productId}/item/new")
    @Transactional
    public ProductDto addItemToProduct(@PathVariable("productId") final Long productId,
                                       @RequestBody final ItemDto itemDto) {
        final Product product = productRepository.findById(productId)
                .orElseThrow(() -> new DataNotFoundException(1001, "Not found productId = " + productId));
        final Item item = productMapper.fromDto(itemDto);
        productService.addItem(product, item);
        return productMapper.toDto(product);
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return productMapper.toDtos(productRepository.findAllWithItems());
    }
}
