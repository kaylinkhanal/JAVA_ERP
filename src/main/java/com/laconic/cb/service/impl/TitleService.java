package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.Title;
import com.laconic.cb.repository.ITitleRepository;
import com.laconic.cb.service.ITitleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitleService implements ITitleService {

    private final ITitleRepository titleRepository;

    public TitleService(ITitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    @Override
    public Title saveTitle(Title title) {
        return titleRepository.save(title);
    }

    @Override
    public Title updateTitle(Title title) {
        return titleRepository.saveAndFlush(title);
    }

    @Override
    public Page<Title> getAllTitles(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return titleRepository.findAllByIsDeletedFalse(pageable);
    }

    @Override
    public List<Title> getAllTitles() {
        return titleRepository.findAllByIsDeletedFalse();
    }

    @Override
    public long getTotalTitles() {
        return titleRepository.countByIsDeletedFalse();
    }

    @Override
    public Optional<Title> findById(Long id) {
        return titleRepository.findByTitleIdAndIsDeletedFalse(id);
    }
}
