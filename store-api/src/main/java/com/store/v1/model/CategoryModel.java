package com.store.v1.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "categories")
@Getter
@Setter
public class CategoryModel extends RepresentationModel<CategoryModel> {

    private Long Id;
    private String name;
}
