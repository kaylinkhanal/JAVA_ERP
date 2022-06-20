package com.laconic.cb.repository;

import com.laconic.cb.model.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query(value = "update INVOICE set IS_DELETED = 1 where INVOICE_ID=:invoiceId", nativeQuery = true)
    @Modifying
    @Transactional
    void softDeleteInvoice(Long invoiceId);

    Optional<Invoice> findByInvoiceIdAndIsDeletedFalse(Long invoiceId);

    Page<Invoice> findAllByIsDeletedFalse(Pageable pageable);
//    List<Invoice> findAllByIsDeletedFalse();

    long countByIsDeletedFalse();
}
