package com.store.v1;

import com.store.v1.controller.BookController;
import com.store.v1.controller.CategoryController;
import com.store.v1.controller.SubCategoryController;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class StoreLinks {


//    public Link linkToDepartments(String rel) {
//        return linkTo(DepartmentController.class).withRel(rel);
//    }
//
    public Link linkToCategory(Long categoryId, String rel) {
        return linkTo(methodOn(CategoryController.class).getSingleCategory(categoryId)).withRel(rel);
    }

    public Link linkToCategory(Long categoryId) {
        return linkToCategory(categoryId, IanaLinkRelations.SELF.value());
    }

    public Link linkToSubCategory(Long subCategoryId, String rel) {
        return linkTo(methodOn(SubCategoryController.class).getSingleSubCategory(subCategoryId)).withRel(rel);
    }

    public Link linkToSubCategory(Long subCategoryId) {
        return linkToSubCategory(subCategoryId, IanaLinkRelations.SELF.value());
    }

    public Link linkToBooks(String rel) {
        return linkTo(BookController.class).withRel(rel);
    }

    public Link linkToCategories(String rel) {
        return linkTo(CategoryController.class).withRel(rel);
    }

    public Link linkToSubCategories(String rel) {
        return linkTo(SubCategoryController.class).withRel(rel);
    }
//
//    public Link linkToAddresses(String rel) {
//        return linkTo(Address.class).withRel(rel);
//    }
}
