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
                if(root.get("offer") != null) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("offer"), bookFilter.getLowPrice()));
                } else {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), bookFilter.getLowPrice()));
                }
            }

            if (bookFilter.getBigPrice() != null) {
                if(root.get("offer") != null) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("offer"), bookFilter.getBigPrice()));
                } else {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), bookFilter.getBigPrice()));
                }
            }

            if (bookFilter.getBrand() != null) {
                predicates.add(criteriaBuilder.equal(root.get("brand"), bookFilter.getBrand()));
            }

            if (bookFilter.getYear() != null) {
                predicates.add(criteriaBuilder.equal(root.get("year"), bookFilter.getYear()));
            }

            if (bookFilter.getAuthor() != null) {
                predicates.add(criteriaBuilder.like(root.get("author"), "%" + bookFilter.getAuthor() + "%"));
            }

            if (bookFilter.getPublishingCompany() != null) {
                predicates.add(criteriaBuilder.equal(root.get("publishingCompany"), bookFilter.getPublishingCompany()));
            }

            if (bookFilter.getCategory() != null) {
                predicates.add(criteriaBuilder.equal(root.get("category").get("name"), bookFilter.getCategory()));
            }

            if (bookFilter.getSubCategory() != null) {
                predicates.add(criteriaBuilder.equal(root.get("subCategory").get("name"), bookFilter.getSubCategory()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
