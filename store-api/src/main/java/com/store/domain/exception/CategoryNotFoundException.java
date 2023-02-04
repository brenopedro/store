package com.store.domain.exception;

import java.util.NoSuchElementException;

public class CategoryNotFoundException extends NoSuchElementException {
    public CategoryNotFoundException(Long id) {
        super(String.format("There is no category with id: %d" , id));
    }
}
