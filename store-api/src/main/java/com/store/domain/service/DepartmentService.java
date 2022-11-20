package com.store.domain.service;

import com.store.domain.exception.DepartmentNotFoundException;
import com.store.domain.model.Department;
import com.store.domain.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Transactional
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    @Transactional
    public void delete(Long departmentId) {
        Department department = getDepartment(departmentId);
        departmentRepository.delete(department);
    }
}
