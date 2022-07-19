package com.laconic.cb.service;

import com.laconic.cb.model.Invoice;
import com.laconic.cb.model.dto.InvoiceDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IInvoiceService {
    Invoice saveInvoice(InvoiceDto invoice);
    Invoice updateInvoice(InvoiceDto invoice);

    Page<Invoice> getAllInvoices(int pageNo, Long caseId);
    List<Invoice> getAllInvoices(Long caseId);

    long getTotalInvoices();

    void softDeleteInvoice(Long id);

    Optional<Invoice> findById(Long id);

    Long getInvoiceNumber();
}
