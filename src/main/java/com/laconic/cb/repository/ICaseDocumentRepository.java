package com.laconic.cb.repository;

import com.laconic.cb.model.Case;
import com.laconic.cb.model.CaseDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICaseDocumentRepository extends JpaRepository<CaseDocument, Long> {
    CaseDocument findByCaseIdAndCaseDocumentId(Long caseId, Long documentId);
}
