package com.laconic.cb.service;

import com.laconic.cb.model.Site;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ISiteService {
    Site addCompanySite(Site site);
    Site updateCompanySite(Site site);

    Page<Site> getAllSites(int pageNo);
    Page<Site> getAllSites(int pageNo, Long customerId);

    List<Site> getSites();

    long getTotalSites();

    List<Site> getAllSites();
    
    void softDeleteSite(Long id);

    Optional<Site> findById(Long id);
}
