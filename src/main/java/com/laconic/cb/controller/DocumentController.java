package com.laconic.cb.controller;

import com.laconic.cb.model.Document;
import com.laconic.cb.model.DocumentType;
import com.laconic.cb.service.IDocumentService;
import com.laconic.cb.service.IDocumentTypeService;
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
@RequestMapping("/document")
public class DocumentController {

    private final IDocumentTypeService documentTypeService;
    private final IDocumentService documentService;

    public DocumentController(IDocumentTypeService documentTypeService, IDocumentService documentService) {
        this.documentTypeService = documentTypeService;
        this.documentService = documentService;
    }

    @GetMapping("/create")
    public String createDocumentTemplate(Model model) {
        List<DocumentType> documentTypes = documentTypeService.getAllDocumentTypes();
        model.addAttribute("documentTypes", documentTypes);
        return "document/documentTemplate";
    }

    @GetMapping("/list")
    public String documentTemplateList(ModelMap modelMap,
                                       @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo) {
        Page<Document> documentPage = documentService.getAllDocuments(pageNo);
        List<Document> documentList = documentPage.getContent().stream().collect(Collectors.toList());
        long totalCount = documentService.getTotalDocuments();
        Pagination.getPagination(modelMap, documentPage, totalCount, documentList, "/document/list");
        return "document/documentList";
    }

    @GetMapping("/typeList")
    public String documentTypeList(ModelMap modelMap,
                                   @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo) {
        Page<DocumentType> documentTypes = documentTypeService.getAllDocumentTypes(pageNo);
        List<DocumentType> documentTypeList = documentTypes.getContent().stream().collect(Collectors.toList());
        long totalCount = documentTypeService.getTotalDocumentTypes();
        Pagination.getPagination(modelMap, documentTypes, totalCount, documentTypeList, "/document/typeList");
        return "document/typeList";
    }

    @PostMapping("/addDocumentType")
    public String addDocumentType(RedirectAttributes model, DocumentType documentType) {
        if (documentType.getDocumentTypeId() != null) {
             documentTypeService.updateDocumentType(documentType);
        } else documentTypeService.saveDocumentType(documentType);
        return "redirect:/document/typeList";
    }
    @GetMapping("/editDocumentType/{id}")
    public String editDocumentType(@PathVariable("id") Long documentTypeId, RedirectAttributes model) {
        Optional<DocumentType> documentType = documentTypeService.findById(documentTypeId);
        if (documentType.isPresent()) {
            model.addFlashAttribute("documentType", documentType.get());
        }
        return "redirect:/document/typeList";
    }

    @GetMapping("/deleteDocumentType/{id}")
    public String deleteDocumentType(@PathVariable("id") Long documentTypeId) {
        documentTypeService.softDeleteDocumentType(documentTypeId);
        return "redirect:/document/typeList";
    }

    @PostMapping("/addDocument")
    public String addDocument(RedirectAttributes model, Document document) {

        //////// needs to be refactored
        document.setDocumentNo(15L);
        if (document.getDocumentId() != null) {
            documentService.updateDocument(document);
        } else documentService.saveDocument(document);
        return "redirect:/document/list";
    }
    @GetMapping("/editDocument/{id}")
    public String editDocument(@PathVariable("id") Long documentId, RedirectAttributes model) {
        Optional<Document> document = documentService.findById(documentId);
        if (document.isPresent()) {
            model.addFlashAttribute("document", document.get());
        }
        return "redirect:/document/create";
    }

    @GetMapping("/deleteDocument/{id}")
    public String deleteDocument(@PathVariable("id") Long documentId) {
        documentService.softDeleteDocument(documentId);
        return "redirect:/document/list";
    }

    ///// need to be refactored
    @GetMapping("/findDocumentTemplate/{id}")
    public String findDocumentTemplate(@PathVariable("id") Long documentId, RedirectAttributes model) {
        Optional<Document> document = documentService.findById(documentId);
        if (document.isPresent()) {
            model.addFlashAttribute("document", document.get());
            if (document.get().getContent() != null) {
                if (document.get().getContent().contains("@Customer")) {
                    document.get().setContent(document.get().getContent().replace("@Customer", "Mandeep Dhakal"));

                }
            }
        }
        System.out.println(document.get().getContent());
        return "redirect:/document/typeList";
    }
}
