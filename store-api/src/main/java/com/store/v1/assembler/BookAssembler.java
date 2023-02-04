package com.store.v1.assembler;

import com.store.domain.model.Book;
import com.store.v1.StoreLinks;
import com.store.v1.controller.BookController;
import com.store.v1.model.BookModel;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class BookAssembler extends RepresentationModelAssemblerSupport<Book, BookModel> {

    private final ModelMapper modelMapper;

    private final StoreLinks storeLinks;

    public BookAssembler(ModelMapper modelMapper, StoreLinks storeLinks) {
        super(BookController.class, BookModel.class);
        this.modelMapper = modelMapper;
        this.storeLinks = storeLinks;
    }

    @Override
    public BookModel toModel(Book book) {
        BookModel bookModel = createModelWithId(book.getId(), book);
        modelMapper.map(book, bookModel);

        bookModel.add(storeLinks.linkToBooks("books"));
        bookModel.getCategory().add(storeLinks.linkToCategory(bookModel.getCategory().getId()));
        bookModel.getSubCategory().add(storeLinks.linkToSubCategory(bookModel.getSubCategory().getId()));
        return bookModel;
    }

    @Override
    public CollectionModel<BookModel> toCollectionModel(Iterable<? extends Book> entities) {
        return super.toCollectionModel(entities);
    }
}
