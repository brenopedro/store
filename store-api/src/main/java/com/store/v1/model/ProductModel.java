package com.store.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.math.BigDecimal;

@Relation(collectionRelation = "products")
@Getter
@Setter
public class ProductModel extends RepresentationModel<ProductModel> {

    @Schema(example = "1")
    private Long Id;

    @Schema(example = "Keyboard husky")
    private String name;

    @Schema(example = "Keyboard husky, black, brown switch")
    private String description;

    @Schema(example = "566.12")
    private BigDecimal price;

    @Schema(example = "165")
    private Integer inventory;

    @Schema(example = "Husky")
    private String brand;

    @Schema(example = "Keyboard")
    private String category;

    @Schema(example = "Computer peripheral")
    private String productType;

    @Schema(example = "true")
    private Boolean active;

    private DepartmentModel department;
    private RateModel rate;
}
