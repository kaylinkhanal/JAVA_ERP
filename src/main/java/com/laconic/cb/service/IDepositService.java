package com.laconic.cb.service;

import com.laconic.cb.model.Deposit;
import com.laconic.cb.model.dto.DepositDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IDepositService {
    Deposit saveDeposit(DepositDto deposit);
    Deposit updateDeposit(DepositDto deposit);
    Page<Deposit> getAllDeposit(int pageNo, Long caseId);
    List<Deposit> getAllDeposit(Long caseId);
    long getTotalDeposits();

    void softDeleteDeposit(Long id);
//    void softDeleteDepositDetail(Long id);

    Optional<Deposit> findById(Long id);

    Long getDepositNumber();
}
