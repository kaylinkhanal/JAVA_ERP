package com.laconic.cb.repository;

import com.laconic.cb.model.DocumentType;
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
public interface IDocumentTypeRepository extends JpaRepository<DocumentType, Long> {
    @Query(value = "update DOCUMENT_TYPE set is_deleted = 1 where DOCUMENT_TYPE_ID=:documentTypeId", nativeQuery = true)
    @Modifying
    @Transactional
    void softDeleteDocumentType(Long documentTypeId);

    Page<DocumentType> findAllByIsDeletedFalse(Pageable pageable);
    List<DocumentType> findAllByIsDeletedFalse();

    Optional<DocumentType> findByDocumentTypeIdAndIsDeletedFalse(Long documentTypeId);

    long countByIsDeletedFalse();
}
