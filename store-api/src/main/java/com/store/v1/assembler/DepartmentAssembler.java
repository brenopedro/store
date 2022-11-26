package com.store.v1.assembler;

import com.store.domain.model.Department;
import com.store.v1.StoreLinks;
import com.store.v1.controller.DepartmentController;
import com.store.v1.model.DepartmentModel;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class DepartmentAssembler extends RepresentationModelAssemblerSupport<Department, DepartmentModel> {

    private final ModelMapper modelMapper;

    private final StoreLinks storeLinks;

    public DepartmentAssembler(ModelMapper modelMapper, StoreLinks storeLinks) {
        super(DepartmentController.class, DepartmentModel.class);
        this.modelMapper = modelMapper;
        this.storeLinks = storeLinks;
    }
    @Override
    public DepartmentModel toModel(Department department) {
        DepartmentModel departmentModel = createModelWithId(department.getId(), department);
        modelMapper.map(department, departmentModel);

        departmentModel.add(storeLinks.linkToDepartments("departments"));
        return departmentModel;
    }

    @Override
    public CollectionModel<DepartmentModel> toCollectionModel(Iterable<? extends Department> entities) {
        return super.toCollectionModel(entities);
    }
}
