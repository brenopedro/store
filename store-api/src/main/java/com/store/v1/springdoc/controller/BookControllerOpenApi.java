package com.store.v1.springdoc.controller;

import com.store.v1.model.BookModel;
import com.store.v1.model.input.BookInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Product")
public interface BookControllerOpenApi {

//    @Operation(summary = "Product list")
//    PagedModel<BookModel> getProductList(BookFilter bookFilter, Pageable pageable);

    @Operation(summary = "Search for product by id",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<BookModel> getProduct(@Parameter(description = "Product ID", example = "1", required = true)
                                            Long productId);

    @Operation(summary = "Add new product",
            responses = {
                    @ApiResponse(responseCode = "201"),
                    @ApiResponse(responseCode = "400", description = "Invalid data",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<BookModel> postProduct(@RequestBody(description = "Input data for product", required = true) BookInput bookInput);

    @Operation(summary = "Update a product",
            responses = {
                    @ApiResponse(responseCode = "201"),
                    @ApiResponse(responseCode = "400", description = "Invalid data",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    ),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<BookModel> putProduct(
            @Parameter(description = "Product ID", example = "1", required = true) Long productId,
            @RequestBody(description = "Input data for product", required = true) BookInput bookInput);

    @Operation(summary = "Delete product by id",
            responses = {
                    @ApiResponse(responseCode = "204"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<Void> deleteProduct(@Parameter(description = "Product ID", example = "1", required = true) Long productId);

}
