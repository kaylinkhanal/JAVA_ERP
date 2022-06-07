package com.laconic.cb.repository;

import com.laconic.cb.model.ContactPerson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IContactPersonRepository extends JpaRepository<ContactPerson, Long> {
    @Query(value = "update CONTACT_PERSON set is_deleted = 1 where CONTACT_PERSON_ID=:contactId", nativeQuery = true)
    @Modifying
    @Transactional
    void softDeleteContact(Long contactId);

    Page<ContactPerson> findAllByIsDeletedFalse(Pageable pageable);
    Optional<ContactPerson> findByContactPersonIdAndIsDeletedFalse(Long addressId);

    long countByIsDeletedFalse();
}
