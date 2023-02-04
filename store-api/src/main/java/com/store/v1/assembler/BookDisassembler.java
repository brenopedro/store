package com.store.v1.assembler;

import com.store.domain.model.Book;
import com.store.domain.model.Category;
import com.store.v1.model.input.BookInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookDisassembler {

    private final ModelMapper modelMapper;

    public Book toDomainObject(BookInput bookInput) {
        return modelMapper.map(bookInput, Book.class);
    }

    public void copyToDomainObject(BookInput bookInput, Book currentBook) {
        currentBook.setCategory(new Category());
        modelMapper.map(bookInput, currentBook);
    }
}
