package com.laconic.cb.controller;

import com.laconic.cb.model.Country;
import com.laconic.cb.model.Document;
import com.laconic.cb.model.DocumentType;
import com.laconic.cb.model.dto.DocumentAttributes;
import com.laconic.cb.service.ICountryService;
import com.laconic.cb.service.IDocumentService;
import com.laconic.cb.service.IDocumentTypeService;
import com.laconic.cb.utils.Pagination;
import com.laconic.cb.utils.ParseDocument;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.laconic.cb.constants.AppConstants.DEFAULT_PAGE_NUMBER;

@Controller
@RequestMapping("/document")
public class DocumentController {

    private final IDocumentTypeService documentTypeService;
    private final IDocumentService documentService;
    private final ICountryService countryService;

    public DocumentController(IDocumentTypeService documentTypeService, IDocumentService documentService, ICountryService countryService) {
        this.documentTypeService = documentTypeService;
        this.documentService = documentService;
        this.countryService = countryService;
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
    @GetMapping("/getTemplate/{documentId}/{documentTypeId}")
    @ResponseBody
    public String findDocumentTemplate(@PathVariable("documentTypeId") Long documentTypeId,
                                       @PathVariable("documentId") Long documentId) {
        Optional<Document> document = documentService.findByDocumentIdAndDocumentTypeId(documentId, documentTypeId);
        if (document.isPresent()) {
            if (document.get().getContent() != null) {
                String content = ParseDocument.getBlankDocument(document.get().getContent());
                document.get().setContent(content);
            }
        }
        return document.get().getContent();
    }

    @PostMapping("/printTemplate")
    @ResponseBody
    public String printTemplate(DocumentAttributes documentAttributes) {
        Optional<Document> document = documentService.findById(documentAttributes.getDocumentId());
        if (document.isPresent()) {
            if (document.get().getContent() != null) {
                String content;
                if (documentAttributes.getNationality() != null && documentAttributes.getAddress() != null &&
                        documentAttributes.getContactNumber() != null && documentAttributes.getDateOfBirth() != null &&
                        documentAttributes.getExecutorName() != null && documentAttributes.getPassportNumber() != null &&
                        documentAttributes.getEffectiveDateTo() != null && documentAttributes.getEffectiveDateFrom() != null) {
                    content = ParseDocument.getParsedDocument(document.get().getContent(), documentAttributes);
                } else content = ParseDocument.getBlankDocument(document.get().getContent());
                document.get().setContent(content);
            }
        }
        return document.get().getContent();
    }

//    @GetMapping("/printBlankDocument/{id}")
//    @ResponseBody
//    public String printBlankDocument(@PathVariable("id") Long documentId) {
//        Optional<Document> document = documentService.findById(documentId);
//        if (document.isPresent()) {
//            return document.get().getContent();
//        }
//        return null;
//    }

    @GetMapping("/findDocumentTemplates/{id}")
    @ResponseBody
    public List<Document> findDocumentTemplates(@PathVariable("id") Long documentTypeId) {
        List<Document> document = documentService.findAllByDocumentTypeId(documentTypeId);
        return document;
    }


    @GetMapping("/preview")
    public String previewDocument(Model model) {
        List<DocumentType> documentTypes = documentTypeService.getAllDocumentTypes();
        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("documentTypes", documentTypes);
        model.addAttribute("countries", countries);
        return "document/previewDocument";
    }
}
