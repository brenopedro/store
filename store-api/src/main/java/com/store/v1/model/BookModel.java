package com.store.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.math.BigDecimal;

@Relation(collectionRelation = "books")
@Getter
@Setter
public class BookModel extends RepresentationModel<BookModel> {

    @Schema(example = "1")
    private Long Id;

    @Schema(example = "A Seleção")
    private String name;

    @Schema(example = "49.90")
    private BigDecimal price;

    @Schema(example = "39.90")
    private BigDecimal offer;

    @Schema(example = "A good book")
    private String description;

    @Schema(example = "WMF Martins Fontes")
    private String brand;

    @Schema(example = "2012")
    private String year;

    @Schema(example = "Cass, Kiera")
    private String author;

    @Schema(example = "Editora Schwarcz SA")
    private String publishingCompany;

    @Schema(example = "Português")
    private String language;

    @Schema(example = "156")
    private Integer numberOfPages;

    @Schema(example = "Livro brochura (paperback)")
    private String finishing;

    @Schema(example = "The Selection")
    private String originalTitle;

    @Schema(example = "9788565765015")
    private String isbn;

    @Schema(example = "165")
    private Integer inventory;

    private CategoryModel category;

    private SubCategoryModel subCategory;
}
