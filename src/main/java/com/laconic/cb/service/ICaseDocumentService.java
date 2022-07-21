package com.laconic.cb.service;

import com.laconic.cb.model.Case;
import com.laconic.cb.model.CaseDocument;
import com.laconic.cb.model.dto.CaseDocumentRequest;

import java.util.List;

public interface ICaseDocumentService {
    Case uploadCaseDocument(CaseDocumentRequest request) throws Exception;

    Case deleteCaseDocument(Long caseId, Long documentId);

    CaseDocument saveDocument(CaseDocument caseDocument);

    List<CaseDocument> getAllCaseDocuments(Long caseId);
}
