package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.Installment;
import com.laconic.cb.repository.IInstallmentRepository;
import com.laconic.cb.service.IInstallmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Page<Installment> getAllInstallment(int pageNo, Long caseId) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return installmentRepository.findAllByIsDeletedFalseAndCaseDto_CaseId(pageable, caseId);
    }

    @Override
    public List<Installment> getAllInstallment(Long caseId) {
        return installmentRepository.findAllByIsDeletedFalseAndCaseDto_CaseId(caseId);
    }

    @Override
    public long getTotalInstallments() {
        return installmentRepository.countByIsDeletedFalse();
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
