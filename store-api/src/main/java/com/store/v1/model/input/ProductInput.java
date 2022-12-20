package com.store.v1.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductInput {

    @Schema(example = "Keyboard husky")
    @NotBlank
    private String name;

    @Schema(example = "Keyboard husky, black, brown switch")
    @NotBlank
    private String description;

    @Schema(example = "566.12")
    @NotNull
    private BigDecimal price;

    @Schema(example = "165")
    @NotNull
    private Integer inventory;

    @Schema(example = "Husky")
    private String brand;

    @Schema(example = "Keyboard")
    @NotBlank
    private String category;

    @Schema(example = "Computer peripheral")
    @NotBlank
    private String productType;

    @Schema(example = "true")
    @NotNull
    private Boolean active;

    @Valid
    @NotNull
    private DepartmentIdInput department;
}
