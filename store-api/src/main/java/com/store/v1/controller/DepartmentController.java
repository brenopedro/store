package com.store.v1.controller;

  import com.store.domain.model.Department;
  import com.store.domain.repository.DepartmentRepository;
import com.store.domain.service.DepartmentService;
import com.store.v1.assembler.DepartmentAssembler;
import com.store.v1.assembler.DepartmentDisassembler;
import com.store.v1.model.DepartmentModel;
import com.store.v1.model.input.DepartmentInput;
import com.store.v1.springdoc.controller.DepartmentControllerOpenApi;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/departments")
public class DepartmentController implements DepartmentControllerOpenApi {

    private final DepartmentAssembler departmentAssembler;
    private final DepartmentDisassembler departmentDisassembler;
    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;


    @GetMapping
    public ResponseEntity<CollectionModel<DepartmentModel>> getDepartmentList() {
        return ResponseEntity.ok(departmentAssembler.toCollectionModel(departmentRepository.findAll()));
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentModel> getDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(departmentAssembler.toModel(departmentService.getDepartment(departmentId)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentModel postDepartment(@RequestBody @Valid DepartmentInput departmentInput) {
        Department departmentSaved = departmentService.save(
                departmentDisassembler.toDomainObject(departmentInput));

        return departmentAssembler.toModel(departmentSaved);
    }

    @DeleteMapping("/{departmentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartment(@PathVariable Long departmentId) {
        departmentService.delete(departmentId);
    }
}
