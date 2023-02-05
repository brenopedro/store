package com.store.domain.filter;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookFilter {

    private String name;
    private BigDecimal lowPrice;
    private BigDecimal bigPrice;
    private String brand;
    private String year;
    private String author;
    private String publishingCompany;
    private String category;
    private String subCategory;


}