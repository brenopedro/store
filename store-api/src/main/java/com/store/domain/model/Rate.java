package com.store.domain.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Rate {

    private Integer totalRates;

    private Integer totalRating;

    private Long mediaRate;
}
