package com.store.v1.model.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubCategoryInput {

    @NotBlank
    public String name;
}
