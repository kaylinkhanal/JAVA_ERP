package com.laconic.cb.repository;

import com.laconic.cb.model.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ITitleRepository extends JpaRepository<Title, Long> {
    Page<Title> findAllByIsDeletedFalse(Pageable pageable);
    List<Title> findAllByIsDeletedFalse();

    long countByIsDeletedFalse();

    Optional<Title> findByTitleIdAndIsDeletedFalse(Long id);
}
