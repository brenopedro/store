package com.store.v1.controller;

import com.store.domain.filter.BookFilter;
import com.store.domain.model.Book;
import com.store.domain.repository.BookRepository;
import com.store.domain.service.BookService;
import com.store.infrastructure.repository.spec.BookSpecs;
import com.store.v1.assembler.BookAssembler;
import com.store.v1.assembler.BookDisassembler;
import com.store.v1.model.BookModel;
import com.store.v1.model.input.BookInput;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/books")
public class BookController {

    private final BookAssembler bookAssembler;
    private final BookDisassembler bookDisassembler;
    private final BookService bookService;
    private final BookRepository bookRepository;
    private final PagedResourcesAssembler<Book> pagedResourcesAssembler;

//    @Override
    @GetMapping
    public PagedModel<BookModel> getProductList(BookFilter bookFilter, @PageableDefault Pageable pageable) {
        Page<Book> productPage = bookRepository.findAll(BookSpecs.filter(bookFilter), pageable);


        return pagedResourcesAssembler.toModel(productPage, bookAssembler);
    }

//    @GetMapping
//    public CollectionModel<BookModel> getBookList() {
//
//
//        return bookAssembler.toCollectionModel(bookRepository.findAll());
//    }

    @GetMapping("/{productId}")
    public ResponseEntity<BookModel> getSingleBook(@PathVariable Long productId) {
        return ResponseEntity.ok(bookAssembler.toModel(bookService.getBook(productId)));
    }

    @PostMapping
    public ResponseEntity<BookModel> postBook(@RequestBody @Valid BookInput bookInput) {
        Book bookSaved = bookService.save(bookDisassembler.toDomainObject(bookInput));

        return ResponseEntity.status(HttpStatus.CREATED).body(bookAssembler.toModel(bookSaved));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<BookModel> putProduct(@PathVariable Long productId, @RequestBody @Valid BookInput bookInput) {
        Book currentBook = bookService.getBook(productId);

        bookDisassembler.copyToDomainObject(bookInput, currentBook);

        return ResponseEntity.ok(bookAssembler.toModel(bookService.save(currentBook)));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long productId) {
        bookService.delete(productId);
        return ResponseEntity.noContent().build();
    }
}
