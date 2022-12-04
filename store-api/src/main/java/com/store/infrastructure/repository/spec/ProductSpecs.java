package com.store.infrastructure.repository.spec;

import com.store.domain.filter.ProductFilter;
import com.store.domain.model.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

public class ProductSpecs {

    public static Specification<Product> filter(ProductFilter productFilter) {
        return (root, query, criteriaBuilder) -> {

            var predicates = new ArrayList<Predicate>();

            if (productFilter.getName() != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + productFilter.getName() + "%"));
            }

            if (productFilter.getLowerPrice() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), productFilter.getLowerPrice()));
            }

            if (productFilter.getBiggerPrice() != null) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), productFilter.getBiggerPrice()));
            }

            if (productFilter.getBrand() != null) {
                predicates.add(criteriaBuilder.equal(root.get("brand"), productFilter.getBrand()));
            }

            if (productFilter.getCategory() != null) {
                predicates.add(criteriaBuilder.equal(root.get("category"), productFilter.getCategory()));
            }

            if (productFilter.getProductType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("productType"), productFilter.getProductType()));
            }

            if (productFilter.getActive() != null) {
                predicates.add(criteriaBuilder.equal(root.get("active"), productFilter.getActive()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
