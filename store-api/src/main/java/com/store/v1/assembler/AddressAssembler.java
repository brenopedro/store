package com.store.v1.assembler;

import com.store.domain.model.Address;
import com.store.v1.controller.AddressController;
import com.store.v1.controller.DepartmentController;
import com.store.v1.model.AddressModel;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class AddressAssembler extends RepresentationModelAssemblerSupport<Address, AddressModel> {

    private final ModelMapper modelMapper;

    public AddressAssembler(ModelMapper modelMapper) {
        super(AddressController.class, AddressModel.class);
        this.modelMapper = modelMapper;
    }
    @Override
    public AddressModel toModel(Address address) {
        AddressModel addressModel = createModelWithId(address.getId(), address);
        modelMapper.map(address, addressModel);

        addressModel.add(linkTo(DepartmentController.class).withRel("address"));
        return addressModel;
    }

    @Override
    public CollectionModel<AddressModel> toCollectionModel(Iterable<? extends Address> entities) {
        return super.toCollectionModel(entities);
    }
}
