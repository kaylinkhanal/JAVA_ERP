package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.*;
import com.laconic.cb.repository.*;
import com.laconic.cb.service.ICaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CaseService implements ICaseService {

    private final ICaseRepository caseRepository;
    private final IInvoiceRepository invoiceRepository;
    private final IInstallmentRepository installmentRepository;
    private final IDepositRepository depositRepository;
    private final ICaseDocumentRepository caseDocumentRepository;
    private final IInvoiceDetailRepository invoiceDetailRepository;

    public CaseService(ICaseRepository caseRepository, IInvoiceRepository invoiceRepository, IInstallmentRepository installmentRepository, IDepositRepository depositRepository,
                       ICaseDocumentRepository caseDocumentRepository, IInvoiceDetailRepository invoiceDetailRepository) {
        this.caseRepository = caseRepository;
        this.invoiceRepository = invoiceRepository;
        this.installmentRepository = installmentRepository;
        this.depositRepository = depositRepository;
        this.caseDocumentRepository = caseDocumentRepository;
        this.invoiceDetailRepository = invoiceDetailRepository;
    }

    @Override
    public Case saveCase(Case caseDto) {
        return caseRepository.save(caseDto);
    }

    @Override
    public Page<Case> getAllCases(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return caseRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public Case updateCase(Case caseDto) {
        return caseRepository.saveAndFlush(caseDto);
    }

    @Override
    public void softDeleteCase(Long caseId) {
        caseRepository.softDeleteCase(caseId);
    }

    @Override
    public Optional<Case> findById(Long id) {
        return caseRepository.findByCaseIdAndIsDeletedFalse(id);
    }

    @Override
    public long getTotalCase() {
        return caseRepository.countByIsDeletedFalse();
    }

    @Override
    public List<Case> searchCase(String keyword) {
        return caseRepository.findByTitleContainingIgnoreCaseOrCustomer_FullNameLikeIgnoreCaseOrCustomer_CompanyNameLikeIgnoreCaseAndIsDeletedFalse(keyword, keyword, keyword);
    }

    @Override
    @Transactional
    public void endCase(Long id) {
        Optional<Case> optionalCase = caseRepository.findByCaseIdAndIsDeletedFalse(id);
        if (optionalCase != null) {
            Case caseDto = optionalCase.get();
            // get case related invoices, installments and deposits
            List<Invoice> caseInvoices = invoiceRepository.findAllByCaseDto_CaseId(caseDto.getCaseId());
            List<Installment> caseInstallments = installmentRepository.findAllByCaseDto_CaseId(caseDto.getCaseId());
            List<Deposit> caseDeposits = depositRepository.findAllByCaseDto_CaseId(caseDto.getCaseId());
            List<CaseDocument> caseDocuments = caseDocumentRepository.findAllByCaseId(caseDto.getCaseId());
            // delete all invoices, installments and deposits related to case
            caseDocumentRepository.deleteAll(caseDocuments);
            installmentRepository.deleteAll(caseInstallments);
            depositRepository.deleteAll(caseDeposits);
            invoiceRepository.deleteAll(caseInvoices);

            // delete the case itself
            caseRepository.delete(caseDto);
        }
    }
}
