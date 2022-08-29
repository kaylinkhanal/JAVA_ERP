package com.laconic.cb.repository;

import com.laconic.cb.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IInvoiceNumberSequenceRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select invoice_number_sequence.nextval from dual", nativeQuery = true)
    Long getNextInvoiceNumberSequence();
}
