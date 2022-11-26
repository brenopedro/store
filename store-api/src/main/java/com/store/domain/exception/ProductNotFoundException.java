package com.store.domain.exception;

import java.util.NoSuchElementException;

public class ProductNotFoundException extends NoSuchElementException {
    public ProductNotFoundException(Long id) {
        super(String.format("There is no product with id: %d" , id));
    }
}
