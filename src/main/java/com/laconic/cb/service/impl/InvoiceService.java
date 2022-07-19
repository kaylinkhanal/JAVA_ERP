package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.*;
import com.laconic.cb.model.dto.InvoiceDto;
import com.laconic.cb.repository.*;
import com.laconic.cb.service.IInvoiceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService implements IInvoiceService {

    private final IInvoiceRepository invoiceRepository;
    private final ICaseRepository caseRepository;
    private final ICurrencyRepository currencyRepository;
    private final IInvoiceDetailRepository invoiceDetailRepository;
    private final IInvoiceNumberSequenceRepository invoiceNumberSequenceRepository;
    private final IItemRepository itemRepository;
    private final IInstallmentRepository installmentRepository;
    private final IDepositRepository depositRepository;

    public InvoiceService(IInvoiceRepository invoiceRepository, ICaseRepository caseRepository, ICurrencyRepository currencyRepository, IInvoiceDetailRepository iInvoiceDetailRepository, IInvoiceNumberSequenceRepository invoiceNumberSequenceRepository, IItemRepository itemRepository, IInstallmentRepository installmentRepository, IDepositRepository iDepositRepository) {
        this.invoiceRepository = invoiceRepository;
        this.caseRepository = caseRepository;
        this.currencyRepository = currencyRepository;
        this.invoiceDetailRepository = iInvoiceDetailRepository;
        this.invoiceNumberSequenceRepository = invoiceNumberSequenceRepository;
        this.itemRepository = itemRepository;
        this.installmentRepository = installmentRepository;
        this.depositRepository = iDepositRepository;
    }

    @Override
    public Invoice saveInvoice(InvoiceDto dto) {
        Invoice invoice = saveInvoiceInformation(dto);
        // save invoice
        Invoice savedInvoice = invoiceRepository.save(invoice);
        // save or update detail
        return getInvoiceDetails(dto, savedInvoice);
    }

    @Override
    public Invoice updateInvoice(InvoiceDto dto) {
        Invoice invoice = saveInvoiceInformation(dto);
        Invoice savedInvoice = invoiceRepository.saveAndFlush(invoice);
        // save or update detail
        return getInvoiceDetails(dto, savedInvoice);
    }

    private Invoice saveInvoiceInformation(InvoiceDto dto) {
        Invoice invoice = new Invoice(dto);
        Case caseDto = caseRepository.findByCaseIdAndIsDeletedFalse(dto.getCaseDto()).get();
        Currency currency = currencyRepository.findById(dto.getCurrency()).get();
        invoice.setCaseDto(caseDto);
        invoice.setCurrency(currency);
        return invoice;
    }

    private Invoice getInvoiceDetails(InvoiceDto dto, Invoice savedInvoice) {
        dto.getDtoList().forEach(x -> {
            InvoiceDetail invoiceDetail = new InvoiceDetail(x);
            Optional<Item> item = itemRepository.findByItemIdAndIsDeletedFalse(x.getItem());
            Optional<Installment> installment = installmentRepository.findByInstallmentIdAndIsDeletedFalse(x.getInstallment());
            Optional<Deposit> deposit = depositRepository.findByDepositIdAndIsDeletedFalse(x.getDeposit());
            if (item.isPresent()) invoiceDetail.setItem(item.get());
            if (installment.isPresent()) invoiceDetail.setInstallment(installment.get());
            if (deposit.isPresent()) invoiceDetail.setDeposit(deposit.get());
            invoiceDetail.setInvoice(savedInvoice);
            if (x.getInvoiceDetailId() != null) {
                invoiceDetailRepository.saveAndFlush(invoiceDetail);
            } else invoiceDetailRepository.save(invoiceDetail);
        });
        return savedInvoice;
    }

    @Override
    public Page<Invoice> getAllInvoices(int pageNo, Long caseId) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return invoiceRepository.findAllByCaseDto_CaseId(pageable, caseId);
    }

    @Override
    public List<Invoice> getAllInvoices(Long caseId) {
        return invoiceRepository.findAllByIsDeletedFalseAndCaseDto_CaseId(caseId);
    }

    @Override
    public long getTotalInvoices() {
        return invoiceRepository.countByIsDeletedFalse();
    }

    @Override
    public void softDeleteInvoice(Long id) {
        invoiceRepository.softDeleteInvoice(id);
    }

    @Override
    public Optional<Invoice> findById(Long id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public Long getInvoiceNumber() {
        return invoiceNumberSequenceRepository.getNextInvoiceNumberSequence();
    }
}
