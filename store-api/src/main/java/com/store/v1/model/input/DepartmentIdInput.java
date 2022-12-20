package com.store.v1.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

@Getter
@Setter
public class DepartmentIdInput {

    @Schema(example = "1")
    @NotNull
    private Long id;
}
