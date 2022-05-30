package com.laconic.cb.service.impl;

import com.laconic.cb.model.Document;
import com.laconic.cb.service.IDocumentService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentService implements IDocumentService {
    @Override
    public Document saveDocument(Document document) {
        return null;
    }

    @Override
    public Page<Document> getAllDocuments(int pageNo) {
        return null;
    }

    @Override
    public Document updateDocument(Document document) {
        return null;
    }

    @Override
    public void softDeleteDocument(Long documentId) {

    }

    @Override
    public Optional<Document> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public long getTotalDocuments() {
        return 0;
    }
}
