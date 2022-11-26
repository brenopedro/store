package com.store.v1.controller;

import com.store.domain.model.Department;
import com.store.domain.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/departments/{id}/products")
public class DepartmentProductController {


    @Autowired
    private DepartmentService departmentService;


    @GetMapping
    public List<Department> teste(@PathVariable Long id) {
        return Collections.singletonList(departmentService.getDepartment(id));
    }
}
