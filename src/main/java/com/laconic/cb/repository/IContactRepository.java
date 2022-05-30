package com.laconic.cb.repository;

import com.laconic.cb.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Long> {
    @Query(value = "update CONTACT set is_deleted = 1 where CONTACT_ID=:contactId", nativeQuery = true)
    @Modifying
    @Transactional
    void softDeleteContact(Long contactId);

    Page<Contact> findAllByIsDeletedFalse(Pageable pageable);
    Optional<Contact> findByContactIdAndIsDeletedFalse(Long addressId);

    long countByIsDeletedFalse();
}
