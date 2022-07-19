package com.laconic.cb.service;

import com.laconic.cb.model.CompanyFinance;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ICompanyFinanceService {
    CompanyFinance saveCompanyFinance(CompanyFinance companyFinance);
    Page<CompanyFinance> getAllCompanyFinance(int pageNo);
    Page<CompanyFinance> getAllCompanyFinance(int pageNo, Long customerId);

    CompanyFinance updateCompanyFinance(CompanyFinance companyFinance);

    void softDeleteCompanyFinance(Long financeId);

    Optional<CompanyFinance> findById(Long id);

    long getTotalCompanyFinance();
}
