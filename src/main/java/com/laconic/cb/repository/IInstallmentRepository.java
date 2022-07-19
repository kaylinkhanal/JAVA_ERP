package com.laconic.cb.repository;

import com.laconic.cb.model.Installment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface IInstallmentRepository extends JpaRepository<Installment, Long> {
    @Query(value = "select installment_number_seq.nextval from dual", nativeQuery = true)
    Long getNextInstallmentNumberSequence();

    Optional<Installment> findByInstallmentIdAndIsDeletedFalse(Long installmentId);

    @Query(value = "update INSTALLMENT set IS_DELETED = 1 where INSTALLMENT_ID=:installmentId", nativeQuery = true)
    @Modifying
    @Transactional
    void softDeleteInstallment(Long installmentId);

//    Optional<Installment> findByInstallmentIdAndIsDeletedFalse(Long installmentId);

    Page<Installment> findAllByIsDeletedFalse(Pageable pageable);
    List<Installment> findAllByCaseDto_CaseId(Long caseId);
    Page<Installment> findAllByCaseDto_CaseId(Pageable pageable, Long caseId);

    long countByIsDeletedFalse();
}
