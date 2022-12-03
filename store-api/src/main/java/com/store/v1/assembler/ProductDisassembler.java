package com.store.v1.assembler;

import com.store.domain.model.Department;
import com.store.domain.model.Product;
import com.store.v1.model.input.ProductInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductDisassembler {

    private final ModelMapper modelMapper;

    public Product toDomainObject(ProductInput productInput) {
        return modelMapper.map(productInput, Product.class);
    }

    public void copyToDomainObject(ProductInput productInput, Product currentProduct) {
        currentProduct.setDepartment(new Department());
        modelMapper.map(productInput, currentProduct);
    }
}
