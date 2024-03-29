package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.Document;
import com.laconic.cb.repository.IDocumentRepository;
import com.laconic.cb.repository.IDocumentSequenceRepository;
import com.laconic.cb.service.IDocumentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService implements IDocumentService {

    private final IDocumentRepository documentRepository;
    private final IDocumentSequenceRepository documentSequenceRepository;

    public DocumentService(IDocumentRepository documentRepository, IDocumentSequenceRepository documentSequenceRepository) {
        this.documentRepository = documentRepository;
        this.documentSequenceRepository = documentSequenceRepository;
    }

    @Override
    public Document saveDocument(Document document) {
        document.setDocumentNo(documentSequenceRepository.getNextDocumentNoSequence());
        return documentRepository.save(document);
    }

    @Override
    public Page<Document> getAllDocuments(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return documentRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public Document updateDocument(Document document) {
        return documentRepository.saveAndFlush(document);
    }

    @Override
    public void softDeleteDocument(Long documentId) {
        documentRepository.softDeleteDocument(documentId);
    }

    @Override
    public Optional<Document> findById(Long id) {
        return documentRepository.findByDocumentIdAndIsDeletedFalse(id);
    }

    @Override
    public long getTotalDocuments() {
        return documentRepository.countByIsDeletedFalse();
    }

    @Override
    public Optional<Document> findByDocumentTypeId(Long documentTypeId) {
        return documentRepository.findByDocumentType_DocumentTypeIdAndIsDeletedFalse(documentTypeId);
    }

    @Override
    public Optional<Document> findByDocumentIdAndDocumentTypeId(Long documentId, Long documentTypeId) {
        return documentRepository.findByDocumentIdAndDocumentType_DocumentTypeIdAndIsDeletedFalse(documentId, documentTypeId);
    }

    @Override
    public List<Document> findAllByDocumentTypeId(Long documentTypeId) {
        return documentRepository.findAllByDocumentType_DocumentTypeIdAndIsDeletedFalse(documentTypeId);
    }

    @Override
    public List<Document> findAllDocumentTemplates() {
        return documentRepository.findAllByIsDeletedFalse();
    }
}
