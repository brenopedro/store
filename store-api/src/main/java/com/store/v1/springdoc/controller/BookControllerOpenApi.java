package com.store.v1.springdoc.controller;

import com.store.domain.filter.BookFilter;
import com.store.v1.model.BookModel;
import com.store.v1.model.input.BookInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;

@Tag(name = "Book")
public interface BookControllerOpenApi {

    @Operation(summary = "Product list",
            responses = {
                    @ApiResponse(responseCode = "200")
            })
    PagedModel<BookModel> getProductList(BookFilter bookFilter, Pageable pageable);

    @Operation(summary = "Search for book by id",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<BookModel> getSingleBook(@Parameter(description = "Book ID", example = "1", required = true)
                                            Long bookId);

    @Operation(summary = "Add new book",
            responses = {
                    @ApiResponse(responseCode = "201"),
                    @ApiResponse(responseCode = "400", description = "Invalid data",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<BookModel> postBook(@RequestBody(description = "Input data for book", required = true)
                                       BookInput bookInput);

    @Operation(summary = "Update a book",
            responses = {
                    @ApiResponse(responseCode = "201"),
                    @ApiResponse(responseCode = "400", description = "Invalid data",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    ),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<BookModel> putBook(
            @Parameter(description = "Book ID", example = "1", required = true) Long bookId,
            @RequestBody(description = "Input data for book", required = true) BookInput bookInput);

    @Operation(summary = "Delete book by id",
            responses = {
                    @ApiResponse(responseCode = "204"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<Void> deleteBook(@Parameter(description = "Book ID", example = "1", required = true) Long bookId);

}
