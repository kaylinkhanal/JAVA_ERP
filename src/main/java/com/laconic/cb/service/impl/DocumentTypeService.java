package com.laconic.cb.service.impl;

import com.laconic.cb.model.DocumentType;
import com.laconic.cb.service.IDocumentTypeService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentTypeService implements IDocumentTypeService {
    @Override
    public DocumentType saveDocumentType(DocumentType documentType) {
        return null;
    }

    @Override
    public Page<DocumentType> getAllDocumentTypes(int pageNo) {
        return null;
    }

    @Override
    public DocumentType updateDocumentType(DocumentType documentType) {
        return null;
    }

    @Override
    public void softDeleteDocumentType(Long documentTypeId) {

    }

    @Override
    public Optional<DocumentType> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public long getTotalDocumentTypes() {
        return 0;
    }
}
