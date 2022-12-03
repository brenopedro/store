package com.store.v1;

import com.store.domain.model.Address;
import com.store.v1.controller.DepartmentController;
import com.store.v1.controller.ProductController;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class StoreLinks {


    public Link linkToDepartments(String rel) {
        return linkTo(DepartmentController.class).withRel(rel);
    }

    public Link linkToDepartment(Long departmentId, String rel) {
        return linkTo(methodOn(DepartmentController.class).getDepartment(departmentId)).withRel(rel);
    }

    public Link linkToDepartment(Long departmentId) {
        return linkToDepartment(departmentId, IanaLinkRelations.SELF.value());
    }

    public Link linkToProducts(String rel) {
        return linkTo(ProductController.class).withRel(rel);
    }

    public Link linkToAddresses(String rel) {
        return linkTo(Address.class).withRel(rel);
    }
}
