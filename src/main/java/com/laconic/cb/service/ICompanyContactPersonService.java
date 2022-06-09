package com.laconic.cb.service;

import com.laconic.cb.model.CompanyContactPerson;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ICompanyContactPersonService {
    CompanyContactPerson saveCompanyContactPerson(CompanyContactPerson companyContactPerson);
    Page<CompanyContactPerson> getAllCompanyContactPerson(int pageNo);

    CompanyContactPerson updateCompanyContactPerson(CompanyContactPerson companyContactPerson);

    void softDeleteCompanyContactPerson(Long contactPersonId);

    Optional<CompanyContactPerson> findById(Long id);

    long getTotalCompanyContactPerson();
}
