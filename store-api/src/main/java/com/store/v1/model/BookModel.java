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

    @Schema(example = "Keyboard husky")
    private String name;

    @Schema(example = "566.12")
    private BigDecimal price;

    @Schema(example = "566.12")
    private BigDecimal offer;

    @Schema(example = "Keyboard husky, black, brown switch")
    private String description;

    @Schema(example = "Husky")
    private String brand;

    private String year;
    
    private String author;
    
    private String publishingCompany;
    
    private String language;

    private Integer numberOfPages;

    private String finishing;

    private String originalTitle;

    private String isbn;

    @Schema(example = "165")
    private Integer inventory;

    private CategoryModel category;

    private SubCategoryModel subCategory;
}
