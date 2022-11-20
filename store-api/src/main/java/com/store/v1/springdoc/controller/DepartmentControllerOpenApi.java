package com.store.v1.springdoc.controller;

import com.store.v1.model.DepartmentModel;
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

@Tag(name = "Department")
public interface DepartmentControllerOpenApi {

    @Operation(summary = "Department list")
    ResponseEntity<CollectionModel<DepartmentModel>> getDepartmentList();

    @Operation(summary = "Search for department by id",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    ResponseEntity<DepartmentModel> getDepartment(@Parameter(description = "Department ID", example = "1", required = true) Long id);

    @Operation(summary = "Add new department",
            responses = {
                    @ApiResponse(responseCode = "200"),
                    @ApiResponse(responseCode = "400", description = "Invalid data",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    DepartmentModel postDepartment(@RequestBody(description = "Input data for department", required = true) DepartmentInput departmentInput);

    @Operation(summary = "Delete department by id",
            responses = {
                    @ApiResponse(responseCode = "204"),
                    @ApiResponse(responseCode = "404", description = "Invalid ID",
                            content = @Content(schema = @Schema(ref = "Problem"))
                    )
            })
    void deleteDepartment(@Parameter(description = "Department ID", example = "1", required = true) Long id);
}
