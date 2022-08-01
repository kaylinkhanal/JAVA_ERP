package com.laconic.cb.controller;

import com.laconic.cb.model.Booking;
import com.laconic.cb.model.BookingDetail;
import com.laconic.cb.model.Case;
import com.laconic.cb.model.SecurityBox;
import com.laconic.cb.service.IBookingService;
import com.laconic.cb.service.ICaseService;
import com.laconic.cb.service.ISecurityBoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    private String createBooking(Model model,
                                 @RequestParam(value = "caseId", required = true) Long caseId) {
        Optional<Case> caseDto = caseService.findById(caseId);
        securityBoxService.findById(caseId);
        List<SecurityBox> securityBoxList = securityBoxService.getSecurityBoxList();
        if (caseDto.isPresent()) {
            model.addAttribute("caseDto", caseDto.get());
        }
        model.addAttribute("boxes", securityBoxList);
        return "booking/create";
    }

    @GetMapping("/edit/{id}")
    private String editBooking(@PathVariable("id") Long bookingId, Model model) {
        Optional<Booking> booking = bookingService.findByBookingId(bookingId);
        List<SecurityBox> securityBoxList = securityBoxService.getSecurityBoxList();
        if (booking.isPresent()) {
            Optional<Case> caseDto = caseService.findById(booking.get().getCaseId());
            model.addAttribute("booking", booking.get());
            model.addAttribute("bookingDetails", booking.get().getBookingDetails());
            if (caseDto.isPresent()) {
                model.addAttribute("caseDto", caseDto.get());
            }
        }
        model.addAttribute("boxes", securityBoxList);
        return "booking/create";
    }

    @GetMapping("/list")
    private String bookingListPage(Model model,
                                   @RequestParam(value = "caseId", required = true) Long caseId) {
        Optional<Case> caseDto = caseService.findById(caseId);
        List<Booking> bookingList = bookingService.getBookingList(caseId);
        model.addAttribute("bookings", bookingList);
        model.addAttribute("caseDto", caseDto.get());
        return "booking/list";
    }

    @PostMapping("/save")
    @ResponseBody
    public Long addBooking(Booking booking) throws Exception {
        Booking savedBooking = bookingService.saveBooking(booking);
        return savedBooking.getBookingId();
    }

    @PostMapping("/saveDetail")
    @ResponseBody
    public String addBookingDetail(@RequestBody List<BookingDetail> bookingDetails) {
        bookingDetails.forEach(x -> {
            bookingService.saveBookingDetail(x);
        });
        return "success";
    }

    @GetMapping("/deleteBookingDetail/{bookingId}/{bookingDetailId}")
    public String deleteBookingDetail(Model model,
                                 @PathVariable("bookingId") Long bookingId, @PathVariable("bookingDetailId") Long bookingDetailId){
        Booking booking = bookingService.deleteBookingDetail(bookingId, bookingDetailId);
        model.addAttribute("booking", booking);
        return "redirect:/booking/edit/"+bookingId;
    }

    @GetMapping("/deleteBookingDocument/{bookingId}")
    public String deleteBookingDocument(Model model, @PathVariable("bookingId") Long bookingId) {
        Booking booking = bookingService.deleteBookingDocument(bookingId);
        model.addAttribute("booking", booking);
        return "redirect:/booking/edit/"+bookingId;
    }
}
