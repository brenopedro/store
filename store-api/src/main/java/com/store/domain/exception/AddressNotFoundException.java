package com.store.domain.exception;

import java.util.NoSuchElementException;

public class AddressNotFoundException extends NoSuchElementException {
    public AddressNotFoundException(Long id) {
        super(String.format("There is no address with id: %d" , id));
    }
}
