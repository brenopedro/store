package com.store.v1.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class DepartmentInput {

    @Schema(example = "Electronics")
    @NotBlank
    private String name;
}
