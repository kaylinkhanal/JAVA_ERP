package com.laconic.cb.repository;

import com.laconic.cb.model.Document;
import com.laconic.cb.model.EmailTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IEmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {
    @Query(value = "update EMAIL_TEMPLATE set is_deleted = 1 where TEMPLATE_ID=:templateId", nativeQuery = true)
    @Modifying
    @Transactional
    void softDeleteEmailTemplate(Long templateId);

    Page<EmailTemplate> findAllByIsDeletedFalse(Pageable pageable);

    long countByIsDeletedFalse();

    Optional<EmailTemplate> findByTemplateIdAndIsDeletedFalse(Long templateId);
}
