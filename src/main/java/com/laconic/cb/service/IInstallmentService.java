package com.laconic.cb.service;

import com.laconic.cb.model.Installment;
import com.laconic.cb.model.dto.InstallmentDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IInstallmentService {
    Installment saveInstallment(InstallmentDto installment);
    Installment updateInstallment(InstallmentDto installment);
    Page<Installment> getAllInstallment(int pageNo, Long caseId);
    List<Installment> getAllInstallment(Long caseId);
    long getTotalInstallments();

    void softDeleteInstallment(Long id);

    Optional<Installment> findById(Long id);

    Long getInstallmentNumber();
}
