package com.store.domain.service;

import com.store.domain.model.Department;
import com.store.domain.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Transactional
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public void delete(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
