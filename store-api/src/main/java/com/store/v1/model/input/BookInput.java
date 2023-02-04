package com.store.v1.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Year;

@Getter
@Setter
public class BookInput {

    @Schema(example = "Keyboard husky")
    @NotBlank
    private String name;

    @Schema(example = "566.12")
    @NotNull
    private BigDecimal price;

    @Schema(example = "566.12")
    private BigDecimal offer;

    @Schema(example = "Keyboard husky, black, brown switch")
    @NotBlank
    private String description;

    @Schema(example = "Husky")
    @NotBlank
    private String brand;

    @NotNull
    private Year year;

    @NotBlank
    private String author;

    @NotBlank
    private String publishingCompany;

    @NotBlank
    private String language;

    @NotNull
    private Integer numberOfPages;

    @NotBlank
    private String finishing;

    @NotBlank
    private String originalTitle;

    @NotBlank
    private String isbn;

    @Schema(example = "165")
    @NotNull
    private Integer inventory;

    @Valid
    @NotNull
    private CategoryIdInput category;

    @Valid
    @NotNull
    private SubCategoryIdInput subCategory;
}
