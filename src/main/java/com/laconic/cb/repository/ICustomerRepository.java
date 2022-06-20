package com.laconic.cb.repository;

import com.laconic.cb.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "update CUSTOMER set is_deleted = 1 where CUSTOMER_ID=:customerId", nativeQuery = true)
    @Modifying
    @Transactional
    void softDeleteCustomer(Long customerId);

    Page<Customer> findAllByIsDeletedFalse(Pageable pageable);
    List<Customer> findAllByIsDeletedFalse();

    long countByIsDeletedFalse();

    Optional<Customer> findByCustomerIdAndIsDeletedFalse(Long customerId);

//    @Query(value = "select * from CUSTOMER where FIRST_NAME like %:keyword% or CODE like %:keyword%", nativeQuery = true)
    List<Customer> findByFullNameContainingIgnoreCaseOrCompanyNameContainingIgnoreCase(String keyword, String keyword1);
}
