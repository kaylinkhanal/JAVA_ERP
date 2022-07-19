package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.CompanyFinance;
import com.laconic.cb.repository.ICompanyFinanceRepository;
import com.laconic.cb.service.ICompanyFinanceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyFinanceService implements ICompanyFinanceService {

    private final ICompanyFinanceRepository companyFinanceRepository;

    public CompanyFinanceService(ICompanyFinanceRepository companyFinanceRepository) {
        this.companyFinanceRepository = companyFinanceRepository;
    }

    @Override
    public CompanyFinance saveCompanyFinance(CompanyFinance companyFinance) {
        return companyFinanceRepository.save(companyFinance);
    }

    @Override
    public Page<CompanyFinance> getAllCompanyFinance(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return companyFinanceRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public Page<CompanyFinance> getAllCompanyFinance(int pageNo, Long customerId) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return companyFinanceRepository.findAllByIsDeletedFalseAndCustomer_CustomerId(pageable, customerId);
    }

    @Override
    public CompanyFinance updateCompanyFinance(CompanyFinance companyFinance) {
        return companyFinanceRepository.saveAndFlush(companyFinance);
    }

    @Override
    public void softDeleteCompanyFinance(Long financeId) {
        companyFinanceRepository.softDeleteCompanyFinance(financeId);
    }

    @Override
    public Optional<CompanyFinance> findById(Long id) {
        return companyFinanceRepository.findByFinanceIdAndIsDeletedFalse(id);
    }

    @Override
    public long getTotalCompanyFinance() {
        return companyFinanceRepository.countByIsDeletedFalse();
    }
}
