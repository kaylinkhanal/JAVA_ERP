package com.laconic.cb.repository;

import com.laconic.cb.model.Deposit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IDepositRepository extends JpaRepository<Deposit, Long> {
    @Query(value = "select deposit_number_seq.nextval from dual", nativeQuery = true)
    Long getNextDepositNumberSequence();

    @Query(value = "update DEPOSIT set IS_DELETED = 1 where DEPOSIT_ID=:depositId", nativeQuery = true)
    @Modifying
    @Transactional
    void softDeleteDeposit(Long depositId);

    Optional<Deposit> findByDepositIdAndIsDeletedFalse(Long depositId);

    Page<Deposit> findAllByCaseDto_CaseId(Pageable pageable, Long caseId);
    List<Deposit> findAllByCaseDto_CaseId(Long caseId);

    long countByIsDeletedFalse();
}
