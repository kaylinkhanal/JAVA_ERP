package com.laconic.cb.service;

import com.laconic.cb.model.Customer;
import com.laconic.cb.service.impl.CustomerService;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ICustomerService {
    Customer save(Customer customer);
    void delete(Long id);
    Customer update(Customer customer);
    Page<Customer> getAllCustomer(int pageNo);

    Optional<Customer> findById(Long customerId);
}
