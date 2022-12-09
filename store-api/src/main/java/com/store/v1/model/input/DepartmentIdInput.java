package com.store.v1.model.input;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class DepartmentIdInput {

    @NotNull
    private Long id;
}
