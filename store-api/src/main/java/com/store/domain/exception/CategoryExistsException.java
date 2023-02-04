package com.store.domain.exception;

import jakarta.persistence.EntityExistsException;

public class CategoryExistsException extends EntityExistsException {

    public CategoryExistsException(String name) {
        super(String.format("Already exists a category with name %s", name));
    }
}
