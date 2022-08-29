package com.laconic.cb.repository;

import com.laconic.cb.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerCodeSequenceRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select customer_code_sequence.nextval from dual", nativeQuery = true)
    Long getNextCustomerCodeSequence();
}
