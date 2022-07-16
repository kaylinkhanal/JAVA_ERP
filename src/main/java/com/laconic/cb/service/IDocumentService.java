package com.laconic.cb.service;

import com.laconic.cb.model.Document;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IDocumentService {
    Document saveDocument(Document document);

    Page<Document> getAllDocuments(int pageNo);

    Document updateDocument(Document document);

    void softDeleteDocument(Long documentId);

    Optional<Document> findById(Long id);

    long getTotalDocuments();

    Optional<Document> findByDocumentTypeId(Long documentTypeId);
    Optional<Document> findByDocumentIdAndDocumentTypeId(Long documentId, Long documentTypeId);
    List<Document> findAllByDocumentTypeId(Long documentTypeId);

    List<Document> findAllDocumentTemplates();
}
