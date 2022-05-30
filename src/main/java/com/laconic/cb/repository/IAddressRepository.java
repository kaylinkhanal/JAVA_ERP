package com.laconic.cb.repository;

import com.laconic.cb.model.Address;
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
public interface IAddressRepository extends JpaRepository<Address, Long> {
    @Query(value = "update ADDRESS set is_deleted = 1 where ADDRESS_ID=:addressId", nativeQuery = true)
    @Modifying
    @Transactional
    void softDeleteAddress(Long addressId);

    Page<Address> findAllByIsDeletedFalse(Pageable pageable);

    Optional<Address> findByAddressIdAndIsDeletedFalse(Long addressId);

    long countByIsDeletedFalse();
}
