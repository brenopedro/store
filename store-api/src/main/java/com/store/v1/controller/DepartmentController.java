package com.store.v1.controller;

import com.store.domain.model.Department;
import com.store.domain.repository.DepartmentRepository;
import com.store.domain.service.DepartmentService;
import com.store.v1.assembler.DepartmentDisassembler;
import com.store.v1.model.DepartmentInput;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/department")
public class DepartmentController {

    private final DepartmentDisassembler departmentDisassembler;
    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;


    @GetMapping
    public ResponseEntity<List<Department>> getDepartmentList() {
        return ResponseEntity.ok(departmentRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id) {
        return ResponseEntity.ok(departmentRepository.findById(id).orElseThrow());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Department postDepartment(@RequestBody @Valid DepartmentInput departmentInput) {
        return departmentService.save(departmentDisassembler.toDomainObject(departmentInput));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.delete(id);
    }
}
