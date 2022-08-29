package com.laconic.cb.repository;

import com.laconic.cb.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IDocumentSequenceRepository extends JpaRepository<Document, Long> {
    @Query(value = "select document_number_sequence.nextval from dual", nativeQuery = true)
    Long getNextDocumentNoSequence();
}