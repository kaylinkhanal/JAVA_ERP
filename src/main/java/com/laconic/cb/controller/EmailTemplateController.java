package com.laconic.cb.controller;

import com.laconic.cb.model.EmailTemplate;
import com.laconic.cb.service.IEmailTemplateService;
import com.laconic.cb.utils.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.laconic.cb.constants.AppConstants.DEFAULT_PAGE_NUMBER;

@Controller
@RequestMapping("/email/")
public class EmailTemplateController {

    private final IEmailTemplateService emailTemplateService;

    public EmailTemplateController(IEmailTemplateService emailTemplateService) {
        this.emailTemplateService = emailTemplateService;
    }

    @GetMapping("/create")
    public String createTemplate(Model model) {
        return "email/create";
    }

    @GetMapping("/editTemplate/{id}")
    public String editTemplate(@PathVariable("id") Long id, RedirectAttributes model) {
        Optional<EmailTemplate> emailTemplate = emailTemplateService.findById(id);
        if (emailTemplate.isPresent()) {
            model.addFlashAttribute("template", emailTemplate.get());
        }
        return "redirect:/email/create";
    }

    @GetMapping("/deleteTemplate/{id}")
    public String deleteTemplate(@PathVariable("id") Long id) {
        emailTemplateService.softDeleteTemplate(id);
        return "redirect:/email/list";
    }

    @GetMapping("/list")
    public String listTemplate(ModelMap modelMap,
                               @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo) {

        Page<EmailTemplate> emailTemplatePage = emailTemplateService.getAllTemplates(pageNo);
        List<EmailTemplate> emailTemplates = emailTemplatePage.getContent().stream().collect(Collectors.toList());
        long totalCount = emailTemplateService.getTotalTemplate();
        Pagination.getPagination(modelMap, emailTemplatePage, totalCount, emailTemplates, "/email/list");
        return "email/templateList";
    }

    @PostMapping("/addTemplate")
    public String addTemplate(RedirectAttributes model, EmailTemplate emailTemplate) {
        EmailTemplate savedEmailTemplate;
        if (emailTemplate.getTemplateId() != null) {
            savedEmailTemplate = emailTemplateService.updateTemplate(emailTemplate);
        } else savedEmailTemplate = emailTemplateService.saveTemplate(emailTemplate);
        model.addFlashAttribute("template", savedEmailTemplate);
        return "redirect:/email/list";
    }
}
