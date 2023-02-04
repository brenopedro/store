package com.store.v1.assembler;

import com.store.domain.model.SubCategory;
import com.store.v1.model.input.SubCategoryInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SubCategoryDisassembler {

    private final ModelMapper modelMapper;

    public SubCategory toDomainObject(SubCategoryInput subCategoryInput) {
        return modelMapper.map(subCategoryInput, SubCategory.class);
    }

    public void copyToDomainObject(SubCategoryInput subCategoryInput, SubCategory currentSubCategory) {
        modelMapper.map(subCategoryInput, currentSubCategory);
    }
}
