package com.example.mapstruct_taya.repository;

import com.example.mapstruct_taya.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select distinct p from Product p join p.items")
    List<Product> findAllWithItems();
}
