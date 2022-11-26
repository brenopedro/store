package com.store.domain.service;

import com.store.domain.exception.DepartmentNotFoundException;
import com.store.domain.exception.EntityInUseException;
import com.store.domain.model.Department;
import com.store.domain.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class DepartmentService {

    private static final String MSG_DEPARTMENT_IN_USE =
            "Department with id %d cannot be deleted because it's been used";
    private final DepartmentRepository departmentRepository;

    @Transactional
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    @Transactional
    public void delete(Long id) {
        try {
            Department department = getDepartment(id);
            departmentRepository.delete(department);
            departmentRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException(String.format(MSG_DEPARTMENT_IN_USE, id));
        }
    }
}
