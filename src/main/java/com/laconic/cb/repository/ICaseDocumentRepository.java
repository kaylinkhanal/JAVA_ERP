package com.laconic.cb.repository;

import com.laconic.cb.model.CaseDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICaseDocumentRepository extends JpaRepository<CaseDocument, Long> {
    CaseDocument findByCaseIdAndCaseDocumentId(Long caseId, Long documentId);

    List<CaseDocument> findAllByCaseId(Long caseId);
}
