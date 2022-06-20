package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.Invoice;
import com.laconic.cb.repository.IInvoiceRepository;
import com.laconic.cb.service.IInvoiceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService implements IInvoiceService {

    private final IInvoiceRepository invoiceRepository;

    public InvoiceService(IInvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice updateInvoice(Invoice invoice) {
        return invoiceRepository.saveAndFlush(invoice);
    }

    @Override
    public Page<Invoice> getAllInvoices(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return invoiceRepository.findAllByIsDeletedFalse(pageable);
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
}
