package com.laconic.cb.controller;

import com.laconic.cb.model.*;
import com.laconic.cb.service.impl.*;
import com.laconic.cb.utils.Pagination;
import com.laconic.cb.utils.SessionStorage;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.laconic.cb.constants.AppConstants.DEFAULT_PAGE_NUMBER;

@Controller
@RequestMapping("/company/")
public class CompanyController {

    public static final int PAGE_SIZE = 2;
    private final SiteService siteService;
    private final CompanyService companyService;

    private final CompanyFinanceService companyFinanceService;

    private final CompanyContactPersonService contactPersonService;

    private final CountryService countryService;

    private final CurrencyService currencyService;

    public CompanyController(SiteService siteService, CompanyService companyService, CompanyFinanceService companyFinanceService, CompanyContactPersonService contactPersonService, CountryService countryService, CurrencyService currencyService) {
        this.siteService = siteService;
        this.companyService = companyService;
        this.companyFinanceService = companyFinanceService;
        this.contactPersonService = contactPersonService;
        this.countryService = countryService;
        this.currencyService = currencyService;
    }

    @GetMapping("/site")
    public String companySite(@RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int page,
            ModelMap modelMap, Model model) {
        Page<Site> sites = siteService.getAllSites(page);
        long totalSites = siteService.getTotalSites();
        Pagination.getPagination(modelMap, sites, totalSites,
                sites.getContent().stream().collect(Collectors.toList()), "/company/site");
        model.addAttribute("countries", countryService.getAllCountries());
        return "company/companySite";
    }

    @GetMapping("/contactPerson")
    public String companyContactPerson(@RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int page,
                                       ModelMap modelMap, Model model) {
        Page<CompanyContactPerson> contactPersonPage = contactPersonService.getAllCompanyContactPerson(page);
        long totalContactPerson = contactPersonService.getTotalCompanyContactPerson();
        Pagination.getPagination(modelMap, contactPersonPage, totalContactPerson,
                contactPersonPage.getContent().stream().collect(Collectors.toList()), "/company/contactPerson");
        model.addAttribute("sites", siteService.getAllSites());
        return "company/companyContactPerson";
    }

    @GetMapping("/finance")
    public String companyFinance(@RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int page,
                                 ModelMap model) {
        Page<CompanyFinance> financePage = companyFinanceService.getAllCompanyFinance(page);
        long totalCompanyFinance = companyFinanceService.getTotalCompanyFinance();
        Pagination.getPagination(model, financePage, totalCompanyFinance,
                financePage.getContent().stream().collect(Collectors.toList()), "/company/finance");
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("currencies", currencyService.getAllCurrencies());
        model.addAttribute("sites", siteService.getAllSites());
        return "company/companyFinance";
    }

    @GetMapping("/information")
    public String companyInformation() {
        return "company/companyInformation";
    }

    @PostMapping("addSite")
    public String addCompanySite(Model model, Site site, HttpSession session, RedirectAttributes redirectAttributes) {
        Site savedSite;
        Customer customer = (Customer) SessionStorage.getStorage(session, "customer");
        Company company = (Company) SessionStorage.getStorage(session, "company");
        site.setCustomer(customer);
        site.setCompanyId(company.getCompanyId());
        if (site.getSiteId() != null) {
            savedSite = siteService.updateCompanySite(site);
        } else {
            savedSite = siteService.addCompanySite(site);
        }
        model.addAttribute("site", savedSite);
        model.addAttribute("company", company);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/company/site";
    }

    @GetMapping("/editSite/{id}")
    public String editSite(@PathVariable("id") Long id, RedirectAttributes model) {
        Optional<Site> site = siteService.findById(id);
        if (site.isPresent()) {
            model.addFlashAttribute("site", site.get());
            model.addFlashAttribute("customer", site.get().getCustomer());
        }
        return "redirect:/company/site";
    }

    @GetMapping("/deleteSite/{id}")
    public String deleteSite(@PathVariable("id") Long id) {
        siteService.softDeleteSite(id);
        return "redirect:/company/site";
    }

    @PostMapping("addCompany")
    public String addCompany(Company company, RedirectAttributes redirectAttributes, HttpSession session) {
        Customer customer = (Customer) SessionStorage.getStorage(session, "customer");
        company.setCustomer(customer);
        Company savedCompany = companyService.save(company);
        SessionStorage.setStorage(session, "company", savedCompany);
        redirectAttributes.addFlashAttribute("company", savedCompany);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/company/information";
    }

    @PostMapping("addCompanyFinance")
    public String addCompanyFinance(CompanyFinance companyFinance, RedirectAttributes redirectAttributes, HttpSession session) {
        Customer customer = (Customer) SessionStorage.getStorage(session, "customer");
        Company company = (Company) SessionStorage.getStorage(session, "company");
        companyFinance.setCustomer(customer);
        companyFinance.setCompany(company);
        CompanyFinance savedCompanyFinance;
        if (companyFinance.getFinanceId() != null) {
            savedCompanyFinance = companyFinanceService.updateCompanyFinance(companyFinance);
        } else {
            savedCompanyFinance = companyFinanceService.saveCompanyFinance(companyFinance);
        }
        redirectAttributes.addFlashAttribute("companyFinance", savedCompanyFinance);
        redirectAttributes.addFlashAttribute("company", company);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/company/finance";
    }

    @PostMapping("addCompanyContactPerson")
    public String addCompanyContactPerson(CompanyContactPerson contactPerson, RedirectAttributes redirectAttributes, HttpSession session) {
        Customer customer = (Customer) SessionStorage.getStorage(session, "customer");
        Company company = (Company) SessionStorage.getStorage(session, "company");
        contactPerson.setCompany(company);
        contactPerson.setCustomer(customer);
        CompanyContactPerson saveContactPerson;
        if (contactPerson.getContactPersonId() != null) {
            saveContactPerson = contactPersonService.updateCompanyContactPerson(contactPerson);
        } else {
            saveContactPerson = contactPersonService.saveCompanyContactPerson(contactPerson);
        }
        redirectAttributes.addFlashAttribute("contact", saveContactPerson);
        redirectAttributes.addFlashAttribute("company", company);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/company/contactPerson";
    }

    @GetMapping("/editContactPerson/{id}")
    public String editContactPerson(@PathVariable("id") Long contactId, RedirectAttributes model) {
        Optional<CompanyContactPerson> contactPerson = contactPersonService.findById(contactId);
        if (contactPerson.isPresent()) {
            model.addFlashAttribute("contact", contactPerson.get());
            model.addFlashAttribute("customer", contactPerson.get().getCustomer());
        }
        return "redirect:/company/contactPerson";

    }

    @GetMapping("/editCompanyFinance/{id}")
    public String editContactFinance(@PathVariable("id") Long financeId, RedirectAttributes model) {
        Optional<CompanyFinance> companyFinance = companyFinanceService.findById(financeId);
        if (companyFinance.isPresent()) {
            model.addFlashAttribute("companyFinance", companyFinance.get());
            model.addFlashAttribute("customer", companyFinance.get().getCustomer());
        }
        return "redirect:/company/finance";
    }

    @GetMapping("/deleteContactPerson/{id}")
    public String deleteContactPerson(@PathVariable("id") Long id) {
        contactPersonService.softDeleteCompanyContactPerson(id);
        return "redirect:/company/contactPerson";
    }

    @GetMapping("/deleteCompanyFinance/{id}")
    public String deleteCompanyFinance(@PathVariable("id") Long id) {
        companyFinanceService.softDeleteCompanyFinance(id);
        return "redirect:/company/finance";
    }
}
