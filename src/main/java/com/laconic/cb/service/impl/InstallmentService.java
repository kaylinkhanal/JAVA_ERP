package com.laconic.cb.service.impl;

import com.laconic.cb.model.Installment;
import com.laconic.cb.repository.IInstallmentRepository;
import com.laconic.cb.service.IInstallmentService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class InstallmentService implements IInstallmentService {
    private final IInstallmentRepository installmentRepository;

    public InstallmentService(IInstallmentRepository installmentRepository) {
        this.installmentRepository = installmentRepository;
    }


    @Override
    public Installment saveInstallment(Installment installment) {
        return installmentRepository.save(installment);
    }

    @Override
    public Installment updateInstallment(Installment installment) {
        return installmentRepository.saveAndFlush(installment);
    }

    @Override
    public Page<Installment> getAllInstallment(int pageNo) {
        return null;
    }

    @Override
    public long getTotalInstallments() {
        return installmentRepository.count();
    }

    @Override
    public void softDeleteInstallment(Long id) {
        installmentRepository.softDeleteInstallment(id);
    }

    @Override
    public Optional<Installment> findById(Long id) {
        return installmentRepository.findByInstallmentIdAndIsDeletedFalse(id);
    }

    @Override
    public Long getInstallmentNumber() {
        return installmentRepository.getNextInstallmentNumberSequence();
    }
}
