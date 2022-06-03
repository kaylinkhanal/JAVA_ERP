package com.laconic.cb.service;

import com.laconic.cb.model.EmailTemplate;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IEmailTemplateService {
    EmailTemplate saveTemplate(EmailTemplate emailTemplate);
    Page<EmailTemplate> getAllTemplates(int pageNo);

    EmailTemplate updateTemplate(EmailTemplate emailTemplate);

    void softDeleteTemplate(Long templateId);

    Optional<EmailTemplate> findById(Long id);

    long getTotalTemplate();
}
