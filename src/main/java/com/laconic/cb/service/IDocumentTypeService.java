package com.laconic.cb.service;

import com.laconic.cb.model.Document;
import com.laconic.cb.model.DocumentType;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IDocumentTypeService {
    DocumentType saveDocumentType(DocumentType documentType);

    Page<DocumentType> getAllDocumentTypes(int pageNo);
    List<DocumentType> getAllDocumentTypes();

    DocumentType updateDocumentType(DocumentType documentType);

    void softDeleteDocumentType(Long documentTypeId);

    Optional<DocumentType> findById(Long id);

    long getTotalDocumentTypes();
}
