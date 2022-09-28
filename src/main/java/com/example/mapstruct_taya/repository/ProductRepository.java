package com.example.mapstruct_taya.repository;

import com.example.mapstruct_taya.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
