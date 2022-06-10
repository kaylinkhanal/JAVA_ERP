package com.laconic.cb.service;

import com.laconic.cb.model.Address;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IAddressService {
    Address saveAddress(Address address);
    Page<Address> getAllAddress(int pageNo);

    Address updateAddress(Address address);

    void softDeleteAddress(Long addressId);

    Optional<Address> findById(Long id);

    long getTotalAddress();

    List<Address> findAddressByCustomerId(Long customerId);
}
