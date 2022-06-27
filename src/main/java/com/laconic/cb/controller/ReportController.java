package com.laconic.cb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report/")
public class ReportController {

    @GetMapping("/securityBox")
    public String securityBox() {
        return "report/securityBox";
    }

    @GetMapping("/paymentStatus")
    public String paymentStatus() {
        return "report/paymentStatus";
    }
}
