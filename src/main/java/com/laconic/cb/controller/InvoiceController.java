package com.laconic.cb.controller;

import com.laconic.cb.model.Case;
import com.laconic.cb.model.Installment;
import com.laconic.cb.model.Invoice;
import com.laconic.cb.model.Item;
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

    public InvoiceController(IInvoiceService invoiceService, IItemService itemService, ICurrencyService currencyService, IInstallmentService installmentService, ICaseService caseService) {
        this.invoiceService = invoiceService;
        this.itemService = itemService;
        this.currencyService = currencyService;
        this.installmentService = installmentService;
        this.caseService = caseService;
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
//        Page<Installment> itemPage = itemService.getAllItems(pageNo);
//        List<Item> itemList = itemPage.getContent().stream().collect(Collectors.toList());
//        long totalItems = itemService.getTotalItems();
//        Pagination.getPagination(modelMap, itemPage, totalItems, itemList, "/invoice/createItem");
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
}
