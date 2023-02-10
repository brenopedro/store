package com.store.v1.springdoc.controller;

import com.store.v1.model.SubCategoryModel;
import com.store.v1.model.input.SubCategoryInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

@Tag(name = "SubCategory")
public interface SubCategoryControllerOpenApi {

    @Operation(summary = "SubCategory list",
            responses = {
                    @ApiResponse(responseCode = "200")
            })
    ResponseEntity<CollectionModel<SubCategoryModel>> getSubCategoryList();

    @Operation(summary = "Search for subCategory by id",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<SubCategoryModel> getSingleSubCategory(@Parameter(description = "SubCategory ID", example = "1", required = true)
                                                    Long subCategoryId);

    @Operation(summary = "Add new subCategory",
            responses = {
                    @ApiResponse(responseCode = "201"),
                    @ApiResponse(responseCode = "400", description = "Invalid data",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<SubCategoryModel> postSubCategory(@RequestBody(description = "Input data for subCategory", required = true)
                                                     SubCategoryInput subCategoryInput);

    @Operation(summary = "Delete subCategory by id",
            responses = {
                    @ApiResponse(responseCode = "204"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<Void> deleteSubCategory(@Parameter(description = "SubCategory ID", example = "1", required = true)
                                        Long subCategoryId);
}
