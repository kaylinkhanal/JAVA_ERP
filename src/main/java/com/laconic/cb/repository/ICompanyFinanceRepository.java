package com.laconic.cb.repository;

import com.laconic.cb.model.CompanyFinance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ICompanyFinanceRepository extends JpaRepository<CompanyFinance, Long> {
    @Query(value = "update COMPANY_FINANCE set is_deleted = 1 where FINANCE_ID=:financeId", nativeQuery = true)
    @Modifying
    @Transactional
    void softDeleteCompanyFinance(Long financeId);

    Page<CompanyFinance> findAllByIsDeletedFalse(Pageable pageable);

    long countByIsDeletedFalse();

    Optional<CompanyFinance> findByFinanceIdAndIsDeletedFalse(Long financeId);
}
