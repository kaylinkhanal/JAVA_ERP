package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.*;
import com.laconic.cb.model.dto.InstallmentDto;
import com.laconic.cb.repository.*;
import com.laconic.cb.service.IInstallmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class InstallmentService implements IInstallmentService {
    private final IInstallmentRepository installmentRepository;
    private final ICustomerRepository customerRepository;
    private final ICurrencyRepository currencyRepository;
    private final ICaseRepository caseRepository;
    private final IItemRepository iItemRepository;
    private final IInstallmentDetailRepository installmentDetailRepository;

    public InstallmentService(IInstallmentRepository installmentRepository, ICustomerRepository customerRepository, ICurrencyRepository currencyRepository, ICaseRepository caseRepository, IItemRepository iItemRepository, IInstallmentDetailRepository iInstallmentDetailRepository) {
        this.installmentRepository = installmentRepository;
        this.customerRepository = customerRepository;
        this.currencyRepository = currencyRepository;
        this.caseRepository = caseRepository;
        this.iItemRepository = iItemRepository;
        this.installmentDetailRepository = iInstallmentDetailRepository;
    }
    @Override
    @Transactional
    public Installment saveInstallment(InstallmentDto dto) {
        Installment installment = getInstallmentInformation(dto);
        Installment savedInstallment = installmentRepository.save(installment);
        // save or update installment detail
        return getInstallment(dto, savedInstallment);
    }

    @Override
    @Transactional
    public Installment updateInstallment(InstallmentDto dto) {
        Installment installment = getInstallmentInformation(dto);
        Installment savedInstallment =  installmentRepository.saveAndFlush(installment);
        // save or update installment detail
        return getInstallment(dto, savedInstallment);
    }

    private Installment getInstallmentInformation(InstallmentDto dto) {
        Installment installment = new Installment(dto);
        Customer customer = customerRepository.findByCustomerIdAndIsDeletedFalse(dto.getCustomer()).get();
        Case caseDto = caseRepository.findByCaseIdAndIsDeletedFalse(dto.getCaseDto()).get();
        Currency currency = currencyRepository.findById(dto.getCurrency()).get();
        installment.setCustomer(customer);
        installment.setCaseDto(caseDto);
        installment.setCurrency(currency);
        return installment;
    }

    private Installment getInstallment(InstallmentDto dto, Installment savedInstallment) {
        dto.getDtoList().forEach(x -> {
            if (x.getItem() != null) {
                InstallmentDetail installmentDetail = new InstallmentDetail(x);
                Optional<Item> item = iItemRepository.findByItemIdAndIsDeletedFalse(x.getItem());
                installmentDetail.setInstallment(savedInstallment);
                if (item.isPresent()) installmentDetail.setItem(item.get());
                if (x.getInstallmentDetailId() != null) {
                    installmentDetailRepository.saveAndFlush(installmentDetail);
                } else installmentDetailRepository.saveAndFlush(installmentDetail);
            }
        });
        return savedInstallment;
    }

    @Override
    public Page<Installment> getAllInstallment(int pageNo, Long caseId) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return installmentRepository.findAllByCaseDto_CaseIdAndIsDeletedFalse(pageable, caseId);
    }

    @Override
    public List<Installment> getAllInstallment(Long caseId) {
        return installmentRepository.findAllByCaseDto_CaseIdAndIsDeletedFalse(caseId);
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
