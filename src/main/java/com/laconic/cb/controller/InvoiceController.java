package com.laconic.cb.controller;

import com.laconic.cb.model.*;
import com.laconic.cb.model.dto.DepositDto;
import com.laconic.cb.service.*;
import com.laconic.cb.utils.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.laconic.cb.constants.AppConstants.DEFAULT_PAGE_NUMBER;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    private final IInvoiceService invoiceService;
    private final IItemService itemService;
    private final ICurrencyService currencyService;
    private final IInstallmentService installmentService;
    private final ICaseService caseService;
    private final IDepositService depositService;
    private final ICustomerService customerService;

    public InvoiceController(IInvoiceService invoiceService, IItemService itemService, ICurrencyService currencyService, IInstallmentService installmentService, ICaseService caseService, IDepositService depositService, ICustomerService customerService) {
        this.invoiceService = invoiceService;
        this.itemService = itemService;
        this.currencyService = currencyService;
        this.installmentService = installmentService;
        this.caseService = caseService;
        this.depositService = depositService;
        this.customerService = customerService;
    }

    @GetMapping("/create")
    public String createInvoice(@RequestParam(value = "caseId", defaultValue = "0", required = false) Long caseId,
                                @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                ModelMap modelMap, Model model) {
        Long invoiceNumber = invoiceService.getInvoiceNumber();
        String number = "INS-"+ String.valueOf(invoiceNumber);
        model.addAttribute("invoiceNumber", number);
        model.addAttribute("caseId", caseId);
        model.addAttribute("currencies", currencyService.getAllCurrencies());
        Page<Invoice> invoicePage = invoiceService.getAllInvoices(pageNo, caseId);
        List<Invoice> invoiceList = invoicePage.getContent().stream().collect(Collectors.toList());
        long totalInvoices = invoiceService.getTotalInvoices();
        Pagination.getPagination(modelMap, invoicePage, totalInvoices, invoiceList, "/invoice/createInvoice");
        return "invoice/createInvoice";
    }

    @GetMapping("/list")
    public String InvoiceList(@RequestParam(value = "caseId", defaultValue = "0", required = false) Long caseId,
                              Model model) {
        List<Invoice> invoiceList = invoiceService.getAllInvoices(caseId);
        model.addAttribute("invoiceList", invoiceList);
        model.addAttribute("caseId", caseId);;
        return "invoice/invoiceList";
    }

    @GetMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable("id") Long id) {
        invoiceService.softDeleteInvoice(id);
        return "redirect:/invoice/create";
    }

    @GetMapping("/edit/{id}")
    public String editInvoice(@PathVariable("id") Long id, Model model) {
        Optional<Invoice> invoice = invoiceService.findById(id);
        if (invoice.isPresent()) {
            model.addAttribute("invoice", invoice.get());
        }
        return "invoice/createInvoice";
    }

    @GetMapping("/detail")
    public String invoiceDetail() {
        return "invoice/invoiceDetail";
    }

    @PostMapping("/addInvoice")
    public String addInvoice(Invoice invoice, RedirectAttributes redirectAttributes) {
        Invoice savedInvoice;
        if (invoice.getInvoiceId() != null) {
            savedInvoice = invoiceService.updateInvoice(invoice);
        } else savedInvoice = invoiceService.saveInvoice(invoice);
        redirectAttributes.addFlashAttribute("invoice", savedInvoice);
        return "redirect:/invoice/create";
    }
    @GetMapping("/createItem")
    public String createItem(@RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                             ModelMap modelMap) {
        Page<Item> itemPage = itemService.getAllItems(pageNo);
        List<Item> itemList = itemPage.getContent().stream().collect(Collectors.toList());
        long totalItems = itemService.getTotalItems();
        Pagination.getPagination(modelMap, itemPage, totalItems, itemList, "/invoice/createItem");
        return "invoice/createItem";
    }

    @GetMapping("/createInstallment")
    public String createInstallment(@RequestParam(value = "caseId", defaultValue = "0", required = false) Long caseId,
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                             ModelMap modelMap, Model model) {
        Page<Installment> installmentPage = installmentService.getAllInstallment(pageNo, caseId);
        List<Installment> installmentList = installmentPage.getContent().stream().collect(Collectors.toList());
        long totalInstallments = installmentService.getTotalInstallments();
        Pagination.getPagination(modelMap, installmentPage, totalInstallments, installmentList, "/invoice/createInstallment");
        if (caseId != null) {
            Case caseDto = caseService.findById(caseId).get();
            model.addAttribute("caseDto", caseDto);
        }
        String installmentNumber = "INS-"+installmentService.getInstallmentNumber();
        model.addAttribute("installmentNumber", installmentNumber);
        model.addAttribute("currencies", currencyService.getAllCurrencies());
        return "invoice/createInstallment";
    }

    @PostMapping("addInstallment")
    public String addInstallment(Installment installment, RedirectAttributes redirectAttributes) {
        Installment savedInstallment;
        if (installment.getInstallmentId() != null) {
            savedInstallment = installmentService.updateInstallment(installment);
        } else savedInstallment = installmentService.saveInstallment(installment);
        redirectAttributes.addFlashAttribute("invoice", savedInstallment);
        return "invoice/createInstallment";
    }

    @GetMapping("/deleteInstallment/{id}")
    public String deleteInstallment(@PathVariable("id") Long id) {
        installmentService.softDeleteInstallment(id);
        return "redirect:/invoice/createInstallment";
    }

    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable("id") Long id) {
        itemService.softDeleteItem(id);
        return "redirect:/invoice/createItem";
    }

    @GetMapping("/findItem/{id}")
    @ResponseBody
    public Item findItem(@PathVariable("id") Long id) {
        Optional<Item> item = itemService.findById(id);
        if (item.isPresent()) {
            return item.get();
        }
        return null;
    }

    @GetMapping("/findInstallment/{id}")
    @ResponseBody
    public Installment findInstallment(@PathVariable("id") Long id) {
        Optional<Installment> installment = installmentService.findById(id);
        if (installment.isPresent()) {
            return installment.get();
        }
        return null;
    }

    @GetMapping("/editItem/{id}")
    public String editItem(@PathVariable("id") Long id, Model model) {
        Optional<Item> item = itemService.findById(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
        }
        return "invoice/createItem";
    }

    @PostMapping("/addItem")
    public String addItem(Item item, RedirectAttributes redirectAttributes) {
        Item savedItem;
        if (item.getItemId() != null) {
            savedItem = itemService.updateItem(item);
        } else savedItem = itemService.saveItem(item);
//        redirectAttributes.addFlashAttribute("item", savedItem);
        return "redirect:/invoice/createItem";
    }

    @GetMapping("/itemList")
    @ResponseBody
    public List<Item> itemList(@RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo) {
        Page<Item> itemPage = itemService.getAllItems(pageNo);
        List<Item> itemList = itemPage.getContent().stream().collect(Collectors.toList());
        return itemList;
    }
    @GetMapping("/installmentList")
    @ResponseBody
    public List<Installment> installmentList(@RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                             @RequestParam(value = "caseId", defaultValue = DEFAULT_PAGE_NUMBER, required = false) Long caseId) {
        return installmentService.getAllInstallment(caseId);
    }

    @GetMapping("/createDeposit")
    public String createDeposit(@RequestParam(value = "caseId", defaultValue = "0", required = false) Long caseId,
                                    @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                    ModelMap modelMap, Model model) {
        Page<Deposit> depositPage = depositService.getAllDeposit(pageNo, caseId);
        List<Deposit> depositList = depositPage.getContent().stream().collect(Collectors.toList());
        long totalDeposits = depositService.getTotalDeposits();
        Pagination.getPagination(modelMap, depositPage, totalDeposits, depositList, "/invoice/createDeposit");
        if (caseId != null) {
            Case caseDto = caseService.findById(caseId).get();
            model.addAttribute("caseDto", caseDto);
        }
        String installmentNumber = "INS-"+depositService.getDepositNumber();
        model.addAttribute("depositNumber", installmentNumber);
        model.addAttribute("currencies", currencyService.getAllCurrencies());
        return "invoice/createDeposit";
    }

    // need to shift logic to service
    @PostMapping("addDeposit")
    public String addDeposit(@RequestBody DepositDto deposit, RedirectAttributes redirectAttributes) {
        Deposit savedDeposit;
        Deposit dbDeposit = new Deposit(deposit);
        Customer customer = customerService.findById(deposit.getCustomer()).get();
        Case caseDto = caseService.findById(deposit.getCaseDto()).get();
        Currency currency = currencyService.findById(deposit.getCurrency());
        dbDeposit.setCustomer(customer);
        dbDeposit.setCaseDto(caseDto);
        dbDeposit.setCurrency(currency);
        if (deposit.getDepositId() != null) {
            savedDeposit = depositService.updateDeposit(dbDeposit);
        } else savedDeposit = depositService.saveDeposit(dbDeposit);
        redirectAttributes.addFlashAttribute("invoice", savedDeposit);
        return "invoice/createDeposit";
    }

    @GetMapping("/depositList")
    @ResponseBody
    public List<Deposit> depositList(@RequestParam(value = "caseId", defaultValue = DEFAULT_PAGE_NUMBER, required = false) Long caseId) {
        return depositService.getAllDeposit(caseId);
    }

    @GetMapping("/findDeposit/{id}")
    @ResponseBody
    public Deposit findDeposit(@PathVariable("id") Long id) {
        Optional<Deposit> deposit = depositService.findById(id);
        if (deposit.isPresent()) {
            return deposit.get();
        }
        return null;
    }

    @GetMapping("/editDeposit/{id}")
    public String editDeposit(@PathVariable("id") Long id, Model model) {
        Optional<Deposit> deposit = depositService.findById(id);
        if (deposit.isPresent()) {
            model.addAttribute("deposit", deposit.get());
        }
        return "invoice/createDeposit";
    }
}
