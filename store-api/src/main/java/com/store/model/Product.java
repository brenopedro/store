package com.store.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String description;
    private BigDecimal price;
    private Integer inventory;
    private BigDecimal offer;
    private String brand;
    private String category;
    private String productType;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Department department;
}
