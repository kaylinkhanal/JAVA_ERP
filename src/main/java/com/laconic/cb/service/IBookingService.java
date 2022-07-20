package com.laconic.cb.service;

import com.laconic.cb.model.Booking;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    Booking saveBooking(Booking booking);
    List<Booking> bookingList(Long caseId);
    Optional<Booking> findBookingByCaseId(Long caseId);
}
