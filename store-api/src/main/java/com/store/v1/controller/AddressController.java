package com.store.v1.controller;

import com.store.domain.model.Address;
import com.store.domain.repository.AddressRepository;
import com.store.domain.service.AddressService;
import com.store.v1.assembler.AddressAssembler;
import com.store.v1.assembler.AddressDisassembler;
import com.store.v1.model.AddressModel;
import com.store.v1.model.input.AddressInput;
import com.store.v1.springdoc.controller.AddressControllerOpenApi;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/address")
public class AddressController implements AddressControllerOpenApi {

    private final AddressAssembler addressAssembler;
    private final AddressDisassembler addressDisassembler;
    private final AddressService addressService;
    private final AddressRepository addressRepository;


    @GetMapping
    public ResponseEntity<CollectionModel<AddressModel>> getAddressList() {
        return ResponseEntity.ok(addressAssembler.toCollectionModel(addressRepository.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressModel> getAddress(@PathVariable Long id) {
        return ResponseEntity.ok(addressAssembler.toModel(addressService.getAddress(id)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressModel postAddress(@RequestBody @Valid AddressInput addressInput) {
        Address addressSaved = addressService.save(
                addressDisassembler.toDomainObject(addressInput));

        return addressAssembler.toModel(addressSaved);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable Long id) {
        addressService.delete(id);
    }
}
