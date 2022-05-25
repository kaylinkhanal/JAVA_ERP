package com.laconic.cb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/case/")
public class CaseController {

    @GetMapping("/list")
    public String caseList() {
        return "caseList";
    }

    @GetMapping("/create")
    public String createCase() {
        return "createCase";
    }

    @GetMapping("/detail")
    public String caseDetail() {
        return "caseDetail";
    }

    @GetMapping("/security")
    public String caseSecurity() {
        return "caseSecurity";
    }
}
