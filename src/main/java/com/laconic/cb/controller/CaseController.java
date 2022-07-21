package com.laconic.cb.controller;

import com.laconic.cb.model.*;
import com.laconic.cb.model.dto.CaseDocumentRequest;
import com.laconic.cb.service.*;
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
    private final ICaseDocumentService caseDocumentService;
    private final IInvoiceService invoiceService;
    private final IInstallmentService installmentService;
    private final IDepositService depositService;
    private final IBookingService bookingService;

    public CaseController(ICaseService caseService, IContactPersonService contactPersonService, ITitleService titleService, IDocumentService documentService, ICaseDocumentService caseDocumentService, IInvoiceService invoiceService, IInstallmentService installmentService, IDepositService depositService, IBookingService bookingService) {
        this.caseService = caseService;
        this.contactPersonService = contactPersonService;
        this.titleService = titleService;
        this.documentService = documentService;
        this.caseDocumentService = caseDocumentService;
        this.invoiceService = invoiceService;
        this.installmentService = installmentService;
        this.depositService = depositService;
        this.bookingService = bookingService;
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
        List<Title> titleList = titleService.getAllTitles();
        model.addAttribute("titles", titleList);
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

    @GetMapping("/endCase/{id}")
    public String endCase(@PathVariable("id") Long id, Model model) {
        Optional<Case> caseOptional = caseService.findById(id);
        if (caseOptional.isPresent()) {
            Case caseDto = caseOptional.get();
//            List<Invoice> caseInvoices = invoiceRepository.findAllByCaseDto_CaseId(caseDto.getCaseId());
//            List<Installment> caseInstallments = installmentRepository.findAllByCaseDto_CaseId(caseDto.getCaseId());
//            List<Deposit> caseDeposits = depositRepository.findAllByCaseDto_CaseId(caseDto.getCaseId());
//            List<CaseDocument> caseDocuments = caseDocumentRepository.findAllByCaseId(caseDto.getCaseId());
            List<Booking> bookingList = bookingService.getBookingList(caseDto.getCaseId());
            model.addAttribute("invoices", invoiceService.getAllInvoices(caseDto.getCaseId()));
            model.addAttribute("installments", installmentService.getAllInstallment(caseDto.getCaseId()));
            model.addAttribute("deposits", depositService.getAllDeposit(caseDto.getCaseId()));
            model.addAttribute("documents", caseDocumentService.getAllCaseDocuments(caseDto.getCaseId()));
            model.addAttribute("bookings", bookingList);
        }
        return "case/endCase";
    }

    @PostMapping("/attachDocument")
    public String attachDocument(CaseDocumentRequest request, Model model) throws Exception {
        Case caseDto = caseDocumentService.uploadCaseDocument(request);
        model.addAttribute("caseDto", caseDto);
        return "redirect:/case/detail/"+caseDto.getCaseId();
    }

    @GetMapping("/deleteCaseDocument/{caseId}/{documentId}")
    public String deleteDocument(Model model,
                                 @PathVariable("caseId") Long caseId, @PathVariable("documentId") Long documentId){
        Case caseDto = caseDocumentService.deleteCaseDocument(caseId, documentId);
        model.addAttribute("caseDto", caseDto);
        return "redirect:/case/detail/"+caseId;
    }
}
