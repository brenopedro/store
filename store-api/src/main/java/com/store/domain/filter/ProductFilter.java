package com.store.domain.filter;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductFilter {

    private String name;
    private BigDecimal lowerPrice;
    private BigDecimal biggerPrice;
    private String brand;
    private String category;
    private String productType;

    private Boolean active;
}