package com.store.v1.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "sub-categories")
@Getter
@Setter
public class SubCategoryModel extends RepresentationModel<SubCategoryModel> {

    private Long Id;
    private String name;
}
