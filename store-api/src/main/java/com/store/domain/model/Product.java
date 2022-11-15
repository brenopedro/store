package com.store.domain.model;

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
    @JoinTable(name = "product_department", joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Department department;
}
