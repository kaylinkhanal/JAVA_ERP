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

@Service
public class SiteService implements ISiteService {

    private final ISiteRepository siteRepository;

    public SiteService(ISiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public void addCompanySite(Site site) {
        siteRepository.save(site);
    }

    @Override
    public Page<Site> getAllSites(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, AppConstants.DEFAULT_PAGE_SIZE);
        return siteRepository.findAll(pageable);
    }

    @Override
    public List<Site> getSites() {
        return siteRepository.findAll();
    }

    @Override
    public long getTotalSites() {
        return siteRepository.count();
    }
}
