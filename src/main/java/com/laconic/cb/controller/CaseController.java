package com.laconic.cb.controller;

import com.laconic.cb.model.Case;
import com.laconic.cb.model.Customer;
import com.laconic.cb.service.ICaseService;
import com.laconic.cb.service.IContactPersonService;
import com.laconic.cb.service.IDocumentService;
import com.laconic.cb.service.ITitleService;
import com.laconic.cb.utils.Pagination;
import com.laconic.cb.utils.SessionStorage;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.laconic.cb.constants.AppConstants.DEFAULT_PAGE_NUMBER;

@Controller
@RequestMapping("/case/")
public class CaseController {

    private final ICaseService caseService;
    private final IContactPersonService contactPersonService;
    private final ITitleService titleService;
    private final IDocumentService documentService;

    public CaseController(ICaseService caseService, IContactPersonService contactPersonService, ITitleService titleService, IDocumentService documentService) {
        this.caseService = caseService;
        this.contactPersonService = contactPersonService;
        this.titleService = titleService;
        this.documentService = documentService;
    }

    @GetMapping("/list")
    public String caseList(@RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int page,
                           ModelMap model) {
        Page<Case> casePage = caseService.getAllCases(page);
        long totalCompanyFinance = caseService.getTotalCase();
        Pagination.getPagination(model, casePage, totalCompanyFinance,
                casePage.getContent().stream().collect(Collectors.toList()), "/case/list");
        return "case/caseList";
    }

    @GetMapping("/searchCase")
    @ResponseBody
    public List<Case> caseList(@RequestParam(value = "keyword", required = true) String keyword,
                           ModelMap model) {
        return caseService.searchCase(keyword);
    }

    @GetMapping("/create")
    public String createCase(HttpSession session, Model model) {
        Customer customer = (Customer) SessionStorage.getStorage(session, "customer");
        model.addAttribute("customer", customer);
        model.addAttribute("contactPersons", contactPersonService.getAllContactPerson());
        model.addAttribute("titles", titleService.getAllTitles());
        return "case/createCase";
    }

    @GetMapping("/detail/{id}")
    public String caseDetail(@PathVariable("id") Long id, Model model, HttpSession session) {
        Optional<Case> getCase = caseService.findById(id);
        if (getCase.isPresent()) {
            model.addAttribute("caseDto", getCase.get());
        }
        model.addAttribute("templates", documentService.findAllDocumentTemplates());
        return "case/caseDetail";
    }

    @GetMapping("/security")
    public String caseSecurity() {
        return "case/caseSecurity";
    }

    @PostMapping("/addCase")
    public String addCase(Case caseDto, RedirectAttributes redirectAttributes, HttpSession session) {
        Case savedCase;
        Customer customer = (Customer) SessionStorage.getStorage(session, "customer");
        if (caseDto.getCaseId() != null) {
            savedCase = caseService.updateCase(caseDto);
        } else savedCase = caseService.saveCase(caseDto);
        redirectAttributes.addAttribute("caseDto", savedCase);
        redirectAttributes.addFlashAttribute("customer", customer);
        return "redirect:/case/list";
    }

    @GetMapping("/editCase/{id}")
    public String editCase(@PathVariable("id") Long id, RedirectAttributes model) {
        Optional<Case> getCase = caseService.findById(id);
        if (getCase.isPresent()) {
            model.addFlashAttribute("caseDto", getCase.get());
        }
        return "redirect:/case/create";
    }

    @GetMapping("/deleteCase/{id}")
    public String deleteCase(@PathVariable("id") Long id) {
        caseService.softDeleteCase(id);
        return "redirect:/case/list";
    }
}
