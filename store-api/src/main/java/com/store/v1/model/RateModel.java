package com.store.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "rate")
@Getter
@Setter
public class RateModel {

    @Schema(example = "142")
    private Integer totalRates;

    @Schema(example = "41")
    private Integer totalRating;

    @Schema(example = "3.5")
    private Long mediaRate;
}
