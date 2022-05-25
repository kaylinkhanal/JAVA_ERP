package com.laconic.cb.service.impl;

import com.laconic.cb.model.Site;
import com.laconic.cb.repository.SiteRepository;
import com.laconic.cb.service.ISiteService;
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
    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }
}
