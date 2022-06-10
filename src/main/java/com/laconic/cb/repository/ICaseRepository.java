package com.laconic.cb.repository;

import com.laconic.cb.model.Case;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ICaseRepository extends JpaRepository<Case, Long> {
    @Query(value = "update CASE set is_deleted = 1 where CASE_ID=:caseId", nativeQuery = true)
    @Modifying
    @Transactional
    void softDeleteCase(Long caseId);

    Page<Case> findAllByIsDeletedFalse(Pageable pageable);

    long countByIsDeletedFalse();

    Optional<Case> findByCaseIdAndIsDeletedFalse(Long caseId);
}
