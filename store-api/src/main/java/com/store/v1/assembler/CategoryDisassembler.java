package com.store.v1.assembler;

import com.store.domain.model.Category;
import com.store.v1.model.input.CategoryInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryDisassembler {

    private final ModelMapper modelMapper;

    public Category toDomainObject(CategoryInput categoryInput) {
        return modelMapper.map(categoryInput, Category.class);
    }

    public void copyToDomainObject(CategoryInput categoryInput, Category currentCategory) {
        modelMapper.map(categoryInput, currentCategory);
    }
}
