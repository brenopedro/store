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

    @Schema(example = "A Seleção")
    @NotBlank
    private String name;

    @Schema(example = "49.90")
    @NotNull
    private BigDecimal price;

    @Schema(example = "39.90")
    private BigDecimal offer;

    @Schema(example = "A good book")
    @NotBlank
    private String description;

    @Schema(example = "WMF Martins Fontes")
    @NotBlank
    private String brand;

    @Schema(example = "2012")
    @NotNull
    private Year year;

    @Schema(example = "Cass, Kiera")
    @NotBlank
    private String author;

    @Schema(example = "Editora Schwarcz SA")
    @NotBlank
    private String publishingCompany;

    @Schema(example = "Português")
    @NotBlank
    private String language;

    @Schema(example = "156")
    @NotNull
    private Integer numberOfPages;

    @Schema(example = "Livro brochura (paperback)")
    @NotBlank
    private String finishing;

    @Schema(example = "The Selection")
    @NotBlank
    private String originalTitle;

    @Schema(example = "9788565765015")
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
