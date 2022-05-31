package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.DocumentType;
import com.laconic.cb.repository.IDocumentTypeRepository;
import com.laconic.cb.service.IDocumentTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentTypeService implements IDocumentTypeService {

    private final IDocumentTypeRepository documentTypeRepository;

    public DocumentTypeService(IDocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }

    @Override
    public DocumentType saveDocumentType(DocumentType documentType) {
        return documentTypeRepository.save(documentType);
    }

    @Override
    public Page<DocumentType> getAllDocumentTypes(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return documentTypeRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public List<DocumentType> getAllDocumentTypes() {
        return documentTypeRepository.findAllByIsDeletedFalse();
    }

    @Override
    public DocumentType updateDocumentType(DocumentType documentType) {
        return documentTypeRepository.saveAndFlush(documentType);
    }

    @Override
    public void softDeleteDocumentType(Long documentTypeId) {
        documentTypeRepository.softDeleteDocumentType(documentTypeId);
    }

    @Override
    public Optional<DocumentType> findById(Long id) {
        return documentTypeRepository.findById(id);
    }

    @Override
    public long getTotalDocumentTypes() {
        return documentTypeRepository.countByIsDeletedFalse();
    }
}
