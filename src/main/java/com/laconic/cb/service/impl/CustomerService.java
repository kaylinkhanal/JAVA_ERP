package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.Customer;
import com.laconic.cb.repository.ICustomerCodeSequenceRepository;
import com.laconic.cb.repository.ICustomerRepository;
import com.laconic.cb.service.ICustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;
    private final ICustomerCodeSequenceRepository customerCodeSequenceRepository;

    public CustomerService(ICustomerRepository customerRepository, ICustomerCodeSequenceRepository customerCodeSequenceRepository) {
        this.customerRepository = customerRepository;
        this.customerCodeSequenceRepository = customerCodeSequenceRepository;
    }

    @Override
    public Customer save(Customer customer) {
        Long code = customerCodeSequenceRepository.getNextCustomerCodeSequence();
        customer.setCode(code);
        return customerRepository.save(customer);
    }

    @Override
    public void softDelete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer update(Customer customer) {
        Optional<Customer> dbCustomer = customerRepository.findById(customer.getCustomerId());
        if (dbCustomer.isPresent()) {
            return customerRepository.saveAndFlush(customer);
        }
        return null;
    }

    @Override
    public Page<Customer> getAllCustomer(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return customerRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public Optional<Customer> findById(Long customerId) {
        return customerRepository.findByCustomerIdAndIsDeletedFalse(customerId);
    }

    @Override
    public long getTotalCustomers() {
        return customerRepository.countByIsDeletedFalse();
    }
}
