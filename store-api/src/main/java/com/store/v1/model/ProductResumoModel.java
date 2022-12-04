package com.store.v1.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.math.BigDecimal;

@Relation(collectionRelation = "products")
@Getter
@Setter
public class ProductResumoModel extends RepresentationModel<ProductResumoModel> {

    private Long Id;
    private String name;
    private BigDecimal price;
    private Integer inventory;
    private String brand;
}
