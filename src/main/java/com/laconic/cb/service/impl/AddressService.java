package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.Address;
import com.laconic.cb.repository.IAddressRepository;
import com.laconic.cb.service.IAddressService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService implements IAddressService {

    private final IAddressRepository addressRepository;

    public AddressService(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Page<Address> getAllAddress(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return addressRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public Address updateAddress(Address address) {
        Optional<Address> dbAddress = addressRepository.findByAddressIdAndIsDeletedFalse(address.getAddressId());

        if (dbAddress.isPresent()) {
            return addressRepository.saveAndFlush(address);
        }
        return null;
    }

    @Override
    public void softDeleteAddress(Long addressId) {
        addressRepository.softDeleteAddress(addressId);
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findByAddressIdAndIsDeletedFalse(id);
    }

    @Override
    public long getTotalAddress() {
        return addressRepository.countByIsDeletedFalse();
    }
}
