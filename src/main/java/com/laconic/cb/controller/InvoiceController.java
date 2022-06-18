package com.laconic.cb.controller;

import com.laconic.cb.model.Invoice;
import com.laconic.cb.model.Item;
import com.laconic.cb.service.IInvoiceService;
import com.laconic.cb.service.IItemService;
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

    public InvoiceController(IInvoiceService invoiceService, IItemService itemService) {
        this.invoiceService = invoiceService;
        this.itemService = itemService;
    }

    @GetMapping("/create")
    public String createInvoice() {
        return "invoice/createInvoice";
    }

    @GetMapping("/list")
    public String InvoiceList(@RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                              ModelMap modelMap) {
        Page<Invoice> invoicePage = invoiceService.getAllInvoices(pageNo);
        List<Invoice> invoiceList = invoicePage.getContent().stream().collect(Collectors.toList());
        long totalInvoices = invoiceService.getTotalInvoices();
        Pagination.getPagination(modelMap, invoicePage, totalInvoices, invoiceList, "/invoice/createInvoice");
        return "invoice/createInvoice";
    }

    @GetMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable("id") Long id) {
        invoiceService.softDeleteInvoice(id);
        return "redirect:/invoice/createInvoice";
    }

    @GetMapping("/edit/{id}")
    public String editInvoice(@PathVariable("id") Long id, Model model) {
        Optional<Invoice> invoice = invoiceService.findById(id);
        if (invoice.isPresent()) {
            model.addAttribute("invoice", invoice.get());
        }
        return "redirect:/invoice/createInvoice";
    }

    @PostMapping("/addInvoice")
    public String addInvoice(Invoice invoice, RedirectAttributes redirectAttributes) {
        Invoice savedInvoice;
        if (invoice.getInvoiceId() != null) {
            savedInvoice = invoiceService.updateInvoice(invoice);
        } else savedInvoice = invoiceService.saveInvoice(invoice);
        redirectAttributes.addFlashAttribute("invoice", savedInvoice);
        return "redirect:/invoice/createInvoice";
    }
    @GetMapping("/createItem")
    public String createItem() {
        return "invoice/createItem";
    }

    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable("id") Long id) {
        itemService.softDeleteItem(id);
        return "redirect:/invoice/createItem";
    }

    @GetMapping("/editItem/{id}")
    public String editItem(@PathVariable("id") Long id, Model model) {
        Optional<Item> item = itemService.findById(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
        }
        return "redirect:/invoice/createItem";
    }

    @PostMapping("/addItem")
    public String addItem(Item item, RedirectAttributes redirectAttributes) {
        Item savedItem;
        if (item.getItemId() != null) {
            savedItem = itemService.updateItem(item);
        } else savedItem = itemService.saveItem(item);
        redirectAttributes.addFlashAttribute("item", savedItem);
        return "redirect:/invoice/createItem";
    }

    @GetMapping("/itemList")
    public String itemList(@RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                              ModelMap modelMap) {
        Page<Item> itemPage = itemService.getAllItems(pageNo);
        List<Item> itemList = itemPage.getContent().stream().collect(Collectors.toList());
        long totalItems = itemService.getTotalItems();
        Pagination.getPagination(modelMap, itemPage, totalItems, itemList, "/invoice/createItem");
        return "invoice/createItem";
    }
}
