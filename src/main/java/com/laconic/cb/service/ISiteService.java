package com.laconic.cb.service;

import com.laconic.cb.model.Site;

import java.util.List;

public interface ISiteService {
    void addCompanySite(Site site);

    List<Site> getAllSites();
}
