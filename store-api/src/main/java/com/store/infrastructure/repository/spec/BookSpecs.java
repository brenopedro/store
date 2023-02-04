package com.store.infrastructure.repository.spec;

public class BookSpecs {

//    public static Specification<Book> filter(BookFilter bookFilter) {
//        return (root, query, criteriaBuilder) -> {
//
//            var predicates = new ArrayList<Predicate>();
//
//            if (bookFilter.getName() != null) {
//                predicates.add(criteriaBuilder.like(root.get("name"), "%" + bookFilter.getName() + "%"));
//            }
//
//            if (bookFilter.getLowerPrice() != null) {
//                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), bookFilter.getLowerPrice()));
//            }
//
//            if (bookFilter.getBiggerPrice() != null) {
//                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), bookFilter.getBiggerPrice()));
//            }
//
//            if (bookFilter.getBrand() != null) {
//                predicates.add(criteriaBuilder.equal(root.get("brand"), bookFilter.getBrand()));
//            }
//
//            if (bookFilter.getCategory() != null) {
//                predicates.add(criteriaBuilder.equal(root.get("category"), bookFilter.getCategory()));
//            }
//
//            if (bookFilter.getProductType() != null) {
//                predicates.add(criteriaBuilder.equal(root.get("productType"), bookFilter.getProductType()));
//            }
//
//            if (bookFilter.getActive() != null) {
//                predicates.add(criteriaBuilder.equal(root.get("active"), bookFilter.getActive()));
//            }
//
//            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//        };
//    }
}
