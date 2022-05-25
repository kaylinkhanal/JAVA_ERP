package com.laconic.cb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/companyInformation")
    public String companyInformation() {
        return "companyInformation";
    }

    @GetMapping("/personalRegister")
    public String personalRegister() {
        return "personalRegister";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/personalContact")
    public String personalContact() {
        return "personalContact";
    }

    @GetMapping("/personalAddress")
    public String personalAddress() {
        return "personalAddress";
    }



}
