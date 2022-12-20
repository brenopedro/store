package com.store.v1.springdoc.controller;

import com.store.domain.filter.ProductFilter;
import com.store.v1.model.ProductModel;
import com.store.v1.model.ProductResumoModel;
import com.store.v1.model.input.ProductInput;
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

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Product")
public interface ProductControllerOpenApi {

    @Operation(summary = "Product list")
    PagedModel<ProductModel> getProductList(ProductFilter productFilter, Pageable pageable);

    @Operation(summary = "Search for product by id",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<ProductModel> getProduct(@Parameter(description = "Product ID", example = "1", required = true)
                                            Long productId);

    @Operation(summary = "Add new product",
            responses = {
                    @ApiResponse(responseCode = "201"),
                    @ApiResponse(responseCode = "400", description = "Invalid data",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ProductModel postProduct(@RequestBody(description = "Input data for product", required = true) ProductInput productInput);

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
    ResponseEntity<ProductModel> putProduct(
            @Parameter(description = "Product ID", example = "1", required = true) Long productId,
            @RequestBody(description = "Input data for product", required = true) ProductInput productInput);

    @Operation(summary = "Delete product by id",
            responses = {
                    @ApiResponse(responseCode = "204"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    void deleteProduct(@Parameter(description = "Product ID", example = "1", required = true) Long productId);

    @Operation(summary = "Activate a product by id",
            responses = {
                    @ApiResponse(responseCode = "204"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<Void> activate(@Parameter(description = "Product ID", example = "1", required = true) Long productId);

    @Operation(summary = "Deactivate a product by id",
            responses = {
                    @ApiResponse(responseCode = "204"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<Void> deactivate(@Parameter(description = "Product ID", example = "1", required = true) Long productId);

    @Operation(summary = "Activate multiples products by id",
            responses = {
                    @ApiResponse(responseCode = "204"),
                    @ApiResponse(responseCode = "400", description = "Invalid data",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    ),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<Void> activateMultiples(
            @Parameter(description = "List of products ID", example = "[1, 2]", required = true) List<Long> productsId);

    @Operation(summary = "Deactivate multiples products by id",
            responses = {
                    @ApiResponse(responseCode = "204"),
                    @ApiResponse(responseCode = "400", description = "Invalid data",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    ),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<Void> deactivateMultiples(
            @Parameter(description = "List of products ID", example = "[1, 2]", required = true) List<Long> productsId);

    @Operation(summary = "Change the price of a product",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", description = "Invalid data",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    ),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<ProductResumoModel> changePrice(
            @Parameter(description = "Product ID", example = "1", required = true) Long productId,
            @Parameter(description = "New price of the product", example = "100.4", required = true) BigDecimal newPrice);

    @Operation(summary = "Change the inventory of a product",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", description = "Invalid data",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    ),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<ProductResumoModel> changeInventory(
            @Parameter(description = "Product ID", example = "1", required = true) Long productId,
            @Parameter(description = "New inventory of the product", example = "100", required = true) Integer newInventory);
}
