package com.laconic.cb.service.impl;

import com.laconic.cb.model.Site;
import com.laconic.cb.repository.SiteRepository;
import com.laconic.cb.service.ISiteService;
import liquibase.pro.packaged.P;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService implements ISiteService {

    private final SiteRepository siteRepository;

    public SiteService(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public void addCompanySite(Site site) {
        siteRepository.save(site);
    }

    @Override
    public Page<Site> getAllSites(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 2);
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
