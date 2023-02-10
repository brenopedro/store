package com.store.v1.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryInput {

    @Schema(example = "Sci-fy")
    @NotBlank
    public String name;
}
