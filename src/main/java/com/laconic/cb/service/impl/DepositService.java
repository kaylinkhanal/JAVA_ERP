package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.Deposit;
import com.laconic.cb.repository.IDepositRepository;
import com.laconic.cb.service.IDepositService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepositService implements IDepositService {
    private final IDepositRepository depositRepository;

    public DepositService(IDepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    @Override
    public Deposit saveDeposit(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    @Override
    public Deposit updateDeposit(Deposit deposit) {
        return depositRepository.saveAndFlush(deposit);
    }

    @Override
    public Page<Deposit> getAllDeposit(int pageNo, Long caseId) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return depositRepository.findAllByIsDeletedFalseAndCaseDto_CaseId(pageable, caseId);
    }

    @Override
    public List<Deposit> getAllDeposit(Long caseId) {
        return depositRepository.findAllByIsDeletedFalseAndCaseDto_CaseId(caseId);
    }

    @Override
    public long getTotalDeposits() {
        return depositRepository.countByIsDeletedFalse();
    }

    @Override
    public void softDeleteDeposit(Long id) {
        depositRepository.softDeleteDeposit(id);
    }

    @Override
    public Optional<Deposit> findById(Long id) {
        return depositRepository.findByDepositIdAndIsDeletedFalse(id);
    }

    @Override
    public Long getDepositNumber() {
        return depositRepository.getNextDepositNumberSequence();
    }
}
