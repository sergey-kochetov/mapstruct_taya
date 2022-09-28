package com.example.mapstruct_taya.repository;

import com.example.mapstruct_taya.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
