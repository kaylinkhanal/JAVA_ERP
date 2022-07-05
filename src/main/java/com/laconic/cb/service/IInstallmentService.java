package com.laconic.cb.service;

import com.laconic.cb.model.Installment;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IInstallmentService {
    Installment saveInstallment(Installment installment);
    Installment updateInstallment(Installment installment);

    Page<Installment> getAllInstallment(int pageNo);
    long getTotalInstallments();

    void softDeleteInstallment(Long id);

    Optional<Installment> findById(Long id);

    Long getInstallmentNumber();
}