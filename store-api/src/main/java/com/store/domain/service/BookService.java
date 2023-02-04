package com.store.domain.service;

import com.store.domain.exception.BookNotFoundException;
import com.store.domain.model.Book;
import com.store.domain.model.Category;
import com.store.domain.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class BookService {

    private final CategoryService categoryService;
    private final BookRepository bookRepository;

    @Transactional
    public Book save(Book book) {
        Long categoryId = book.getCategory().getId();
        Category category = categoryService.getCategory(categoryId);

        book.setCategory(category);
        return bookRepository.save(book);
    }

    public Book getBook(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
    }

    @Transactional
    public void delete(Long bookId) {
        Book book = getBook(bookId);
        bookRepository.delete(book);
    }

}
