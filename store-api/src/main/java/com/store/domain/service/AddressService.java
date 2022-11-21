package com.store.domain.service;

import com.store.domain.exception.AddressNotFoundException;
import com.store.domain.model.Address;
import com.store.domain.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    @Transactional
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
    }

    @Transactional
    public void delete(Long addressId) {
        Address address = getAddress(addressId);
        addressRepository.delete(address);
    }
}
