package com.store.v1.springdoc.controller;

import com.store.v1.model.AddressModel;
import com.store.v1.model.DepartmentModel;
import com.store.v1.model.input.AddressInput;
import com.store.v1.model.input.DepartmentInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

@Tag(name = "Address")
public interface AddressControllerOpenApi {

    @Operation(summary = "Address list")
    ResponseEntity<CollectionModel<AddressModel>> getAddressList();

    @Operation(summary = "Search for address by id",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<AddressModel> getAddress(@Parameter(description = "Address ID", example = "1", required = true) Long id);

    @Operation(summary = "Add new address",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", description = "Invalid data",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    AddressModel postAddress(@RequestBody(description = "Input data for address", required = true) AddressInput addressInput);

    @Operation(summary = "Delete address by id",
            responses = {
                    @ApiResponse(responseCode = "204"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    void deleteAddress(@Parameter(description = "Address ID", example = "1", required = true) Long id);
}
