package com.store.domain.exception;

import java.util.NoSuchElementException;

public class BookNotFoundException extends NoSuchElementException {
    public BookNotFoundException(Long id) {
        super(String.format("There is no book with id: %d" , id));
    }
}
