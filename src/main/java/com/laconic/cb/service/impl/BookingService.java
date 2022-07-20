package com.laconic.cb.service.impl;

import com.laconic.cb.model.Booking;
import com.laconic.cb.repository.IBookingRepository;
import com.laconic.cb.service.IBookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IBookingService {
    private final IBookingRepository bookingRepository;

    public BookingService(IBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> bookingList(Long caseId) {
        return bookingRepository.findAllByCaseDto_CaseId(caseId);
    }

    @Override
    public Optional<Booking> findBookingByCaseId(Long caseId) {
        return bookingRepository.findByCaseDto_CaseId(caseId);
    }
}
