package com.laconic.cb.service;

import com.laconic.cb.model.Site;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISiteService {
    void addCompanySite(Site site);

    Page<Site> getAllSites(int pageNo);

    List<Site> getSites();

    long getTotalSites();

    List<Site> getAllSites();
}
