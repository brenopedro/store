package com.store.v1.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.math.BigDecimal;

@Relation(collectionRelation = "products")
@Getter
@Setter
public class ProductModel extends RepresentationModel<ProductModel> {

    private Long Id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer inventory;
    private String brand;
    private String category;
    private String productType;
    private Boolean active;
    private DepartmentModel department;
}
