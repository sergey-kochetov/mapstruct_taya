package com.example.mapstruct_taya.service;

import com.example.mapstruct_taya.model.Item;
import com.example.mapstruct_taya.model.Product;
import com.example.mapstruct_taya.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ProductService {
    private ItemRepository itemRepository;

    @Transactional
    public void addItem(final Product product, final Item item) {
        item.setProduct(product);
        final Item save = itemRepository.save(item);
        product.getItems().add(save);
    }
}
