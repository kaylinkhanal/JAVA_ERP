package com.laconic.cb.repository;

import com.laconic.cb.model.CompanyContactPerson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ICompanyContactPersonRepository extends JpaRepository<CompanyContactPerson, Long> {
    @Query(value = "update COMPANY_CONTACT_PERSON set is_deleted = 1 where CONTACT_PERSON_ID=:contactPersonId", nativeQuery = true)
    @Modifying
    @Transactional
    void softDeleteCompanyContactPerson(Long contactPersonId);

    Page<CompanyContactPerson> findAllByIsDeletedFalse(Pageable pageable);

    long countByIsDeletedFalse();

    Optional<CompanyContactPerson> findByContactPersonIdAndIsDeletedFalse(Long contactPersonId);
}
