package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.CompanyContactPerson;
import com.laconic.cb.repository.ICompanyContactPersonRepository;
import com.laconic.cb.service.ICompanyContactPersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyContactPersonService implements ICompanyContactPersonService {

    private final ICompanyContactPersonRepository companyContactPersonRepository;

    public CompanyContactPersonService(ICompanyContactPersonRepository companyContactPersonRepository) {
        this.companyContactPersonRepository = companyContactPersonRepository;
    }

    @Override
    public CompanyContactPerson saveCompanyContactPerson(CompanyContactPerson companyContactPerson) {
        return companyContactPersonRepository.save(companyContactPerson);
    }

    @Override
    public Page<CompanyContactPerson> getAllCompanyContactPerson(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return companyContactPersonRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public CompanyContactPerson updateCompanyContactPerson(CompanyContactPerson companyContactPerson) {
        return companyContactPersonRepository.saveAndFlush(companyContactPerson);
    }

    @Override
    public void softDeleteCompanyContactPerson(Long contactPersonId) {
        companyContactPersonRepository.softDeleteCompanyContactPerson(contactPersonId);
    }

    @Override
    public Optional<CompanyContactPerson> findById(Long id) {
        return companyContactPersonRepository.findByContactPersonIdAndIsDeletedFalse(id);
    }

    @Override
    public long getTotalCompanyContactPerson() {
        return companyContactPersonRepository.countByIsDeletedFalse();
    }
}
