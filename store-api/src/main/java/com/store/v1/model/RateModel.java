package com.store.v1.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "rate")
@Getter
@Setter
public class RateModel {

    private Integer totalRates;
    private Integer totalRating;
    private Long mediaRate;
}
