package com.laconic.cb.service;

import com.laconic.cb.model.Case;
import com.laconic.cb.model.EmailTemplate;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ICaseService {
    Case saveCase(Case caseDto);
    Page<Case> getAllCases(int pageNo);

    Case updateCase(Case caseDto);

    void softDeleteCase(Long caseId);

    Optional<Case> findById(Long id);

    long getTotalCase();

    List<Case> searchCase(String keyword);
}
