package com.store.v1.springdoc.controller;

import com.store.domain.model.Department;
import com.store.v1.model.DepartmentModel;
import com.store.v1.model.input.DepartmentInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;

@Tag(name = "Department")
public interface DepartmentControllerOpenApi {

    @Operation(summary = "Department list")
    ResponseEntity<CollectionModel<DepartmentModel>> getDepartmentList();

    ResponseEntity<Department> getDepartment(Long id);

    Department postDepartment(DepartmentInput departmentInput);

    void deleteDepartment(Long id);
}
