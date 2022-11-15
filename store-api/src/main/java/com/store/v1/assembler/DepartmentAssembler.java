package com.store.v1.assembler;

import com.store.domain.model.Department;
import com.store.v1.model.DepartmentModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DepartmentAssembler {

    private final ModelMapper modelMapper;

    public DepartmentModel toDomain(Department department) {
        return modelMapper.map(department, DepartmentModel.class);
    }

    public List<DepartmentModel> toCollectionModel(List<Department> departmentList) {
        return departmentList.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}
