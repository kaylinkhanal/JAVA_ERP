package com.laconic.cb.controller;

import com.laconic.cb.model.EmailTemplate;
import com.laconic.cb.service.IEmailTemplateService;
import com.laconic.cb.utils.EmailSender;
import com.laconic.cb.utils.Pagination;
import org.springframework.core.io.InputStreamSource;
import org.springframework.data.domain.Page;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.laconic.cb.constants.AppConstants.DEFAULT_PAGE_NUMBER;

@Controller
@RequestMapping("/email/")
public class EmailTemplateController {

    private final IEmailTemplateService emailTemplateService;
    private final JavaMailSender javaMailSender;

    public EmailTemplateController(IEmailTemplateService emailTemplateService, JavaMailSender javaMailSender) {
        this.emailTemplateService = emailTemplateService;
        this.javaMailSender = javaMailSender;
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

        getTemplateList(pageNo, modelMap, "/email/list");
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

    @GetMapping("/viewTemplate/{id}")
    public String findEmailTemplate(@PathVariable("id") Long templateId, Model model) {
        Optional<EmailTemplate> template = emailTemplateService.findById(templateId);
        if(template.isPresent()) {
            model.addAttribute("template", template.get());
        }
        return "email/detail";
    }

    @GetMapping("/createAttach")
    public String createAttachEmail(ModelMap modelMap,
                                    @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) int pageNo) {
        getTemplateList(pageNo, modelMap, "/email/createAttach");
        return "email/createAttachTemplate";
    }

    private void getTemplateList(int pageNo, ModelMap modelMap, String pageUrl) {
        Page<EmailTemplate> emailTemplatePage = emailTemplateService.getAllTemplates(pageNo);
        List<EmailTemplate> emailTemplates = emailTemplatePage.getContent().stream().collect(Collectors.toList());
        long totalCount = emailTemplateService.getTotalTemplate();
        Pagination.getPagination(modelMap, emailTemplatePage, totalCount, emailTemplates, pageUrl);
    }

    @PostMapping("/sendEmail")
    public String sendEmail(EmailTemplate emailTemplate) {
        try {
            sendEmail("aryandhakal60@gmail.com", emailTemplate.getSubject(), emailTemplate.getContent(), emailTemplate.getAttachImage());
        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/email/list";
    }
    public void sendEmail(String sendTo, String subject, String content, MultipartFile multipartFile) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(sendTo);
//        message.setText(content);
//        message.setSubject(subject);
//        message.setFrom("mandeepdhakal11@gmail.com");
//        message.setSentDate(new Date());
//        message.setReplyTo("mandeepdhakal11@gmail.com");
//        javaMailSender.send(message);
        javaMailSender.send(new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, true, "UTF-8");
                messageHelper.setTo("mandeepdhakal11@gmail.com");
                messageHelper.setSubject(subject);
                messageHelper.setText(content);
                messageHelper.setFrom("mandeepdhakal11@gmail.com");

                // determines if there is an upload file, attach it to the e-mail
                String attachName = multipartFile.getOriginalFilename();
                if (!multipartFile.equals("")) {

                    messageHelper.addAttachment(attachName, new InputStreamSource() {

                        @Override
                        public InputStream getInputStream() throws IOException {
                            return multipartFile.getInputStream();
                        }
                    });
                }

            }

        });
    }

}
