package com.laconic.cb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/document")
public class DocumentController {
    @GetMapping("/create")
    public String companyInformation() {
        return "documentTemplate";
    }
}
