package com.store.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "categories")
@Getter
@Setter
public class CategoryModel extends RepresentationModel<CategoryModel> {

    @Schema(example = "1")
    private Long Id;

    @Schema(example = "Autoajuda")
    private String name;
}
