package com.store.v1.assembler;

import com.store.domain.model.Address;
import com.store.domain.model.Department;
import com.store.v1.model.input.AddressInput;
import com.store.v1.model.input.DepartmentInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressDisassembler {

    private final ModelMapper modelMapper;

    public Address toDomainObject(AddressInput addressInput) {
        return modelMapper.map(addressInput, Address.class);
    }
}
