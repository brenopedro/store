package com.store.domain.exception;

import java.util.NoSuchElementException;

public class DepartmentNotFoundException extends NoSuchElementException {
    public DepartmentNotFoundException(Long id) {
        super(String.format("There is no department with id: %d" , id));
    }
}
