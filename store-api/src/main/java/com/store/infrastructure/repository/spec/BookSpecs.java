package com.store.infrastructure.repository.spec;

import com.store.domain.filter.BookFilter;
import com.store.domain.model.Book;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;

public class BookSpecs {

    public static Specification<Book> filter(BookFilter bookFilter) {
        return (root, query, criteriaBuilder) -> {

            var predicates = new ArrayList<Predicate>();

            if (bookFilter.getName() != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + bookFilter.getName() + "%"));
            }

            // colocar filtro para comparar com a oferta caso não seja nula
            if (bookFilter.getLowPrice() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), bookFilter.getLowPrice()));
            }

            if (bookFilter.getBigPrice() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), bookFilter.getBigPrice()));
            }

            if (bookFilter.getBrand() != null) {
                predicates.add(criteriaBuilder.equal(root.get("brand"), bookFilter.getBrand()));
            }

            if (bookFilter.getYear() != null) {
                predicates.add(criteriaBuilder.equal(root.get("year"), bookFilter.getYear()));
            }

            // botar filtro igual ao nome
            if (bookFilter.getAuthor() != null) {
                predicates.add(criteriaBuilder.equal(root.get("author"), bookFilter.getAuthor()));
            }

            if (bookFilter.getPublishingCompany() != null) {
                predicates.add(criteriaBuilder.equal(root.get("publishingCompany"), bookFilter.getPublishingCompany()));
            }

            if (bookFilter.getCategory() != null) {
                predicates.add(criteriaBuilder.equal(root.get("category"), bookFilter.getCategory()));
            }

            if (bookFilter.getSubCategory() != null) {
                predicates.add(criteriaBuilder.equal(root.get("subCategory"), bookFilter.getSubCategory()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
