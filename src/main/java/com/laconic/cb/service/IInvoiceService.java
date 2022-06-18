package com.laconic.cb.service;

import com.laconic.cb.model.Invoice;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IInvoiceService {
    Invoice saveInvoice(Invoice invoice);
    Invoice updateInvoice(Invoice invoice);

    Page<Invoice> getAllInvoices(int pageNo);

    long getTotalInvoices();

    void softDeleteInvoice(Long id);

    Optional<Invoice> findById(Long id);
}
