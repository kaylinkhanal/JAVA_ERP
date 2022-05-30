package com.laconic.cb.controller;

import com.laconic.cb.model.Document;
import com.laconic.cb.model.DocumentType;
import com.laconic.cb.service.IDocumentService;
import com.laconic.cb.service.IDocumentTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
    public String createDocumentTemplate() {
        return "document/documentTemplate";
    }

    @GetMapping("/typeList")
    public String documentTypeList() {
        return "document/typeList";
    }

    @PostMapping("/addDocumentType")
    public String addDocumentType(RedirectAttributes model, DocumentType documentType) {
        DocumentType savedDocumentType;
        if (documentType.getDocumentTypeId() != null) {
            savedDocumentType = documentTypeService.updateDocumentType(documentType);
        } else savedDocumentType = documentTypeService.saveDocumentType(documentType);
        model.addFlashAttribute("documentType", savedDocumentType);
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
        Document savedDocument;
        if (document.getDocumentId() != null) {
            savedDocument = documentService.updateDocument(document);
        } else savedDocument = documentService.saveDocument(document);
        model.addFlashAttribute("document", savedDocument);
        return "redirect:/document/List";
    }
    @GetMapping("/editDocument/{id}")
    public String editDocument(@PathVariable("id") Long documentId, RedirectAttributes model) {
        Optional<Document> document = documentService.findById(documentId);
        if (document.isPresent()) {
            model.addFlashAttribute("document", document.get());
        }
        return "redirect:/document/List";
    }

    @GetMapping("/deleteDocument/{id}")
    public String deleteDocument(@PathVariable("id") Long documentId) {
        documentService.softDeleteDocument(documentId);
        return "redirect:/document/List";
    }
}
