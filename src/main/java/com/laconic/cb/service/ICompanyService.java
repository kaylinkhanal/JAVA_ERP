package com.laconic.cb.service;

import com.laconic.cb.model.Company;
import com.laconic.cb.model.Customer;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ICompanyService {
    Company save(Company company);
    void delete(Long id);
    Company update(Company company);
    Page<Company> getAllCompany(int pageNo);

    Optional<Company> findById(Long companyId);
}
