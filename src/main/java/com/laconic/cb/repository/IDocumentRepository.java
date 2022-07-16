package com.laconic.cb.repository;

import com.laconic.cb.model.Document;
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
public interface IDocumentRepository extends JpaRepository<Document, Long> {
    @Query(value = "update DOCUMENT set is_deleted = 1 where DOCUMENT_ID=:documentId", nativeQuery = true)
    @Modifying
    @Transactional
    void softDeleteDocument(Long documentId);

    Page<Document> findAllByIsDeletedFalse(Pageable pageable);
    List<Document> findAllByIsDeletedFalse();

    Optional<Document> findByDocumentIdAndIsDeletedFalse(Long documentId);

    long countByIsDeletedFalse();

    Optional<Document> findByDocumentType_DocumentTypeIdAndIsDeletedFalse(Long documentTypeId);

    Optional<Document> findByDocumentIdAndDocumentType_DocumentTypeIdAndIsDeletedFalse(Long documentId, Long documentTypeId);

    List<Document> findAllByDocumentType_DocumentTypeIdAndIsDeletedFalse(Long documentTypeId);
}
