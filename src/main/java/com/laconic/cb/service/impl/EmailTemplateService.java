package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.EmailTemplate;
import com.laconic.cb.repository.IEmailTemplateRepository;
import com.laconic.cb.service.IEmailTemplateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailTemplateService implements IEmailTemplateService {

    private final IEmailTemplateRepository templateRepository;

    public EmailTemplateService(IEmailTemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    @Override
    public EmailTemplate saveTemplate(EmailTemplate emailTemplate) {
        return templateRepository.save(emailTemplate);
    }

    @Override
    public Page<EmailTemplate> getAllTemplates(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return templateRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public EmailTemplate updateTemplate(EmailTemplate emailTemplate) {
        return templateRepository.saveAndFlush(emailTemplate);
    }

    @Override
    public void softDeleteTemplate(Long templateId) {
        templateRepository.softDeleteEmailTemplate(templateId);
    }

    @Override
    public Optional<EmailTemplate> findById(Long id) {
        return templateRepository.findByTemplateIdAndIsDeletedFalse(id);
    }

    @Override
    public long getTotalTemplate() {
        return templateRepository.countByIsDeletedFalse();
    }
}
