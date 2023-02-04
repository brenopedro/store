package com.store.domain.exception;

import jakarta.persistence.EntityExistsException;

public class SubCategoryExistsException extends EntityExistsException {

    public SubCategoryExistsException(String name) {
        super(String.format("Already exists a sub category with name %s", name));
    }
}
