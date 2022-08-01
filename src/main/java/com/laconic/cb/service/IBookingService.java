package com.laconic.cb.service;

import com.laconic.cb.model.Booking;
import com.laconic.cb.model.BookingDetail;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    Booking saveBooking(Booking booking) throws Exception;
    BookingDetail saveBookingDetail(BookingDetail bookingDetail);
    List<Booking> getBookingList(Long caseId);
    List<BookingDetail> getBookingDetailList(Long bookingId);
    Optional<Booking> findByCaseId(Long caseId);
    Optional<Booking> findByBookingId(Long bookingId);

    Booking deleteBookingDetail(Long bookingId, Long bookingDetailId);

    Booking deleteBookingDocument(Long bookingId);
}
