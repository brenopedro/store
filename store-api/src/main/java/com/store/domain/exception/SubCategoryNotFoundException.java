package com.store.domain.exception;

import java.util.NoSuchElementException;

public class SubCategoryNotFoundException extends NoSuchElementException {
    public SubCategoryNotFoundException(Long id) {
        super(String.format("There is no sub category with id: %d" , id));
    }
}
