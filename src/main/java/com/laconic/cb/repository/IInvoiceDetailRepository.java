package com.laconic.cb.repository;

import com.laconic.cb.model.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {
}
