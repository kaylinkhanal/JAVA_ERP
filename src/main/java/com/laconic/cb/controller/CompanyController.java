package com.laconic.cb.controller;

import com.laconic.cb.model.Site;
import com.laconic.cb.service.impl.SiteService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

import static com.laconic.cb.constants.AppConstants.DEFAULT_PAGE_NUMBER;

@Controller
@RequestMapping("/company/")
public class CompanyController {

    public static final int PAGE_SIZE = 2;
    private final SiteService siteService;

    public CompanyController(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping("/site")
    public String companySite(@RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int page,
            ModelMap model, HttpServletRequest request) {
//        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        Page<Site> sites = siteService.getAllSites(page);
        long totalSites = siteService.getTotalSites();
        int lastPageNo;
        List<Site> siteList = sites.getContent().stream().collect(Collectors.toList());
//        int totalSites = 10; //total no of users
        if (totalSites % PAGE_SIZE != 0)
            lastPageNo = (int)(totalSites / PAGE_SIZE) + 1; // get last page No (zero based)
        else
            lastPageNo = (int)(totalSites / PAGE_SIZE);
        model.addAttribute("currentPage", sites.getNumber());
        model.addAttribute("isFirst", sites.isFirst());
        model.addAttribute("isLast", sites.isLast());
        model.addAttribute("lastPageNo", lastPageNo);
        model.addAttribute("pagedListHolder", siteList);
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
        model.addAttribute("companySites", siteService.getAllSites(0));
        return "redirect:site";
    }
}
