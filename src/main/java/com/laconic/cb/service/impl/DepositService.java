package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.*;
import com.laconic.cb.model.dto.DepositDto;
import com.laconic.cb.repository.*;
import com.laconic.cb.service.IDepositService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepositService implements IDepositService {
    private final IDepositRepository depositRepository;
    private final ICustomerRepository customerRepository;
    private final ICaseRepository caseRepository;
    private final ICurrencyRepository currencyRepository;
    private final IItemRepository itemRepository;
    private final IDepositDetailRepository depositDetailRepository;

    public DepositService(IDepositRepository depositRepository, ICustomerRepository customerRepository, ICaseRepository caseRepository, ICurrencyRepository currencyRepository, IItemRepository itemRepository, IDepositDetailRepository depositDetailRepository) {
        this.depositRepository = depositRepository;
        this.customerRepository = customerRepository;
        this.caseRepository = caseRepository;
        this.currencyRepository = currencyRepository;
        this.itemRepository = itemRepository;
        this.depositDetailRepository = depositDetailRepository;
    }

    @Override
    public Deposit saveDeposit(DepositDto dto) {
       Deposit deposit = getDepositInformation(dto);
       Deposit savedDeposit = depositRepository.save(deposit);
       return getDeposit(dto, savedDeposit);
    }

    private Deposit getDeposit(DepositDto dto, Deposit savedDeposit) {
        dto.getDtoList().forEach(x -> {
            if (x.getItem() != null) {
                DepositDetail depositDetail = new DepositDetail(x);
                Optional<Item> item = itemRepository.findByItemIdAndIsDeletedFalse(x.getItem());
                depositDetail.setDeposit(savedDeposit);
                if (item.isPresent()) depositDetail.setItem(item.get());
                if (x.getDepositDetailId() != null) {
                    depositDetailRepository.saveAndFlush(depositDetail);
                } else depositDetailRepository.saveAndFlush(depositDetail);
            }
        });
        return savedDeposit;
    }

    private Deposit getDepositInformation(DepositDto dto) {
        Deposit deposit = new Deposit(dto);
        Customer customer = customerRepository.findByCustomerIdAndIsDeletedFalse(dto.getCustomer()).get();
        Case caseDto = caseRepository.findByCaseIdAndIsDeletedFalse(dto.getCaseDto()).get();
        Currency currency = currencyRepository.findById(dto.getCurrency()).get();
        deposit.setCustomer(customer);
        deposit.setCaseDto(caseDto);
        deposit.setCurrency(currency);
        return deposit;
    }

    @Override
    public Deposit updateDeposit(DepositDto dto) {
        Deposit deposit = getDepositInformation(dto);
        Deposit saveDeposit = depositRepository.saveAndFlush(deposit);
        return getDeposit(dto, saveDeposit);
    }

    @Override
    public Page<Deposit> getAllDeposit(int pageNo, Long caseId) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return depositRepository.findAllByCaseDto_CaseIdAndIsDeletedFalse(pageable, caseId);
    }

    @Override
    public List<Deposit> getAllDeposit(Long caseId) {
        return depositRepository.findAllByCaseDto_CaseIdAndIsDeletedFalse(caseId);
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
