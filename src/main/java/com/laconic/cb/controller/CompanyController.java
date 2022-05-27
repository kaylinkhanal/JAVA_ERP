package com.laconic.cb.controller;

import com.laconic.cb.model.Site;
import com.laconic.cb.service.impl.SiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company/")
public class CompanyController {

    private final SiteService siteService;

    public CompanyController(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping("/site")
    public String companySite(Model model) {
        model.addAttribute("companySites", siteService.getAllSites());
        return "company/companySite";
    }

    @GetMapping("/contactPerson")
    public String companyContactPerson() {
        return "company/companyContactPerson";
    }

    @GetMapping("/finance")
    public String companyFinance() {
        return "company/companyFinance";
    }

    @GetMapping("/information")
    public String companyInformation() {
        return "company/companyInformation";
    }

    @PostMapping("addSite")
    public String addCompanySite(Model model,Site site) {
        siteService.addCompanySite(site);
        model.addAttribute("companySites", siteService.getAllSites());
        return "redirect:site";
    }
}
