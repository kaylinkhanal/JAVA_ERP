package com.laconic.cb.service;

import com.laconic.cb.model.Title;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ITitleService {
    Title saveTitle(Title title);
    Title updateTitle(Title title);
    Page<Title> getAllTitles(int pageNo);
    List<Title> getAllTitles();
    long getTotalTitles();
    Optional<Title> findById(Long id);
}
