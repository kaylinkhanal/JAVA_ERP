package com.laconic.cb.controller;

import com.laconic.cb.model.Booking;
import com.laconic.cb.model.SecurityBox;
import com.laconic.cb.service.IBookingService;
import com.laconic.cb.service.ICaseService;
import com.laconic.cb.service.ISecurityBoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/booking/")
public class BookingController {
    private final ICaseService caseService;
    private final IBookingService bookingService;
    private final ISecurityBoxService securityBoxService;

    public BookingController(ICaseService caseService, IBookingService bookingService, ISecurityBoxService securityBoxService) {
        this.caseService = caseService;
        this.bookingService = bookingService;
        this.securityBoxService = securityBoxService;
    }

    @GetMapping("/create")
    private String createBooking(Model model) {
        List<SecurityBox> securityBoxList = securityBoxService.getSecurityBoxList();
        model.addAttribute("boxes", securityBoxList);
        return "booking/create";
    }

    @PostMapping("/save")
    public String addBooking(Booking booking) {
        bookingService.saveBooking(booking);
        return "redirect:/case/list";
    }
}
