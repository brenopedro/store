package com.store.v1.assembler;

import com.store.domain.model.Department;
import com.store.v1.model.input.DepartmentInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DepartmentDisassembler {

    private final ModelMapper modelMapper;

    public Department toDomainObject(DepartmentInput departmentInput) {
        return modelMapper.map(departmentInput, Department.class);
    }
}
