package com.store.v1.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class DepartmentInput {

    @NotBlank
    private String name;
}
