package com.store.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "sub-categories")
@Getter
@Setter
public class SubCategoryModel extends RepresentationModel<SubCategoryModel> {

    @Schema(example = "1")
    private Long Id;

    @Schema(example = "Literatura Juvenil")
    private String name;
}
