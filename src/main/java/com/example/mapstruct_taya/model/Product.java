package com.example.mapstruct_taya.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter
@Setter
@Accessors(chain = true)
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "desc")
    private String desc;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price", precision = 19, scale = 2)
    private BigDecimal price;

}
