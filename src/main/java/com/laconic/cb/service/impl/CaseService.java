package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.Case;
import com.laconic.cb.repository.ICaseRepository;
import com.laconic.cb.service.ICaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaseService implements ICaseService {

    private final ICaseRepository caseRepository;

    public CaseService(ICaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    @Override
    public Case saveCase(Case caseDto) {
        return caseRepository.save(caseDto);
    }

    @Override
    public Page<Case> getAllCases(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return caseRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public Case updateCase(Case caseDto) {
        return caseRepository.saveAndFlush(caseDto);
    }

    @Override
    public void softDeleteCase(Long caseId) {
        caseRepository.softDeleteCase(caseId);
    }

    @Override
    public Optional<Case> findById(Long id) {
        return caseRepository.findByCaseIdAndIsDeletedFalse(id);
    }

    @Override
    public long getTotalCase() {
        return caseRepository.countByIsDeletedFalse();
    }

    @Override
    public List<Case> searchCase(String keyword) {
        return caseRepository.findByTitleContainingIgnoreCaseOrCustomer_FullNameLikeIgnoreCaseOrCustomer_CompanyNameLikeIgnoreCaseAndIsDeletedFalse(keyword, keyword, keyword);
    }
}
