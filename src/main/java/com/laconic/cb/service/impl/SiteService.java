package com.laconic.cb.service.impl;

import com.laconic.cb.constants.AppConstants;
import com.laconic.cb.model.Site;
import com.laconic.cb.repository.ISiteRepository;
import com.laconic.cb.service.ISiteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiteService implements ISiteService {

    private final ISiteRepository siteRepository;

    public SiteService(ISiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public Site addCompanySite(Site site) {
        return siteRepository.save(site);
    }

    @Override
    public Site updateCompanySite(Site site) {
        return siteRepository.saveAndFlush(site);
    }

    @Override
    public Page<Site> getAllSites(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return siteRepository.findAllByIsDeletedFalse(pageable);
    }
    @Override
    public Page<Site> getAllSites(int pageNo, Long customerId) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return siteRepository.findAllByIsDeletedFalseAndCustomer_CustomerId(pageable, customerId);
    }

    @Override
    public List<Site> getSites() {
        return siteRepository.findAll();
    }

    @Override
    public long getTotalSites() {
        return siteRepository.countByIsDeletedFalse();
    }

    @Override
    public List<Site> getAllSites() {
        return siteRepository.findAllByIsDeletedFalse();
    }

    @Override
    public void softDeleteSite(Long id) {
        siteRepository.softDeleteSite(id);
    }

    @Override
    public Optional<Site> findById(Long id) {
        return siteRepository.findBySiteIdAndIsDeletedFalse(id);
    }
}
