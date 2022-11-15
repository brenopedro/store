package com.store.v1.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class DepartmentModel extends RepresentationModel<DepartmentModel> {

    private Long id;
    private String name;
}
