package com.laconic.cb.service;

import com.laconic.cb.model.Deposit;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IDepositService {
    Deposit saveDeposit(Deposit deposit);
    Deposit updateDeposit(Deposit deposit);
    Page<Deposit> getAllDeposit(int pageNo, Long caseId);
    List<Deposit> getAllDeposit(Long caseId);
    long getTotalDeposits();

    void softDeleteDeposit(Long id);

    Optional<Deposit> findById(Long id);

    Long getDepositNumber();
}
