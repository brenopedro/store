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
public class ProductResumoModel extends RepresentationModel<ProductResumoModel> {

    @Schema(example = "1")
    private Long Id;

    @Schema(example = "Keyboard husky")
    private String name;

    @Schema(example = "566.12")
    private BigDecimal price;

    @Schema(example = "165")
    private Integer inventory;

    @Schema(example = "Husky")
    private String brand;
}
