package com.store.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.AbstractAggregateRoot;

import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book extends AbstractAggregateRoot<Book> {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

//    @Column(nullable = false)
    private BigDecimal offer;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String publishingCompany;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private Integer numberOfPages;

    @Column(nullable = false)
    private String finishing;

    @Column(nullable = false)
    private String originalTitle;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private Integer inventory;

    @ManyToOne
    @JoinTable(name = "book_category", joinColumns = @JoinColumn(name = "book_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Category category;

    @ManyToOne
    @JoinTable(name = "book_sub_category", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "sub_category_id"))
    private SubCategory subCategory;
}
