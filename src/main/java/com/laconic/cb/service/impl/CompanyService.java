package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.Company;
import com.laconic.cb.repository.ICompanyRepository;
import com.laconic.cb.service.ICompanyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {

    private final ICompanyRepository companyRepository;

    public CompanyService(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Company update(Company company) {
        return companyRepository.saveAndFlush(company);
    }

    @Override
    public Page<Company> getAllCompany(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return companyRepository.findAll(pageable);
    }

    @Override
    public Optional<Company> findById(Long companyId) {
        return companyRepository.findById(companyId);
    }
}
