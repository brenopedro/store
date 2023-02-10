package com.store.v1.springdoc.controller;

import com.store.v1.model.CategoryModel;
import com.store.v1.model.input.CategoryInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

@Tag(name = "Category")
public interface CategoryControllerOpenApi {

    @Operation(summary = "Category list",
            responses = {
                    @ApiResponse(responseCode = "200")
            })
    ResponseEntity<CollectionModel<CategoryModel>> getCategoryList();

    @Operation(summary = "Search for category by id",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<CategoryModel> getSingleCategory(@Parameter(description = "Category ID", example = "1", required = true)
                                                    Long categoryId);

    @Operation(summary = "Add new category",
            responses = {
                    @ApiResponse(responseCode = "201"),
                    @ApiResponse(responseCode = "400", description = "Invalid data",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<CategoryModel> postCategory(@RequestBody(description = "Input data for category", required = true)
                                               CategoryInput categoryInput);

    @Operation(summary = "Delete category by id",
            responses = {
                    @ApiResponse(responseCode = "204"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<Void> deleteCategory(@Parameter(description = "Category ID", example = "1", required = true)
                                        Long categoryId);
}
