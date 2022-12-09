package com.store.v1.model.input;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductInput {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Integer inventory;

    private String brand;

    @NotBlank
    private String category;

    @NotBlank
    private String productType;

    @NotNull
    private Boolean active;

    @Valid
    @NotNull
    private DepartmentIdInput department;
}
