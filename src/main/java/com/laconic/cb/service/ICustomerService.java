package com.laconic.cb.service;

import com.laconic.cb.model.Customer;
import com.laconic.cb.model.dto.CustomerResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Customer save(Customer customer);
    void softDelete(Long id);
    Customer update(Customer customer);
    Page<Customer> getAllCustomer(int pageNo);
    List<Customer> getAllCustomer();

    List<Customer> findCustomer(String keyword);

    Optional<Customer> findById(Long customerId);

    long getTotalCustomers();
}
