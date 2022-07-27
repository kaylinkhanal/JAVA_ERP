package com.laconic.cb.repository;

import com.laconic.cb.model.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookingDetailRepository extends JpaRepository<BookingDetail, Long> {
    List<BookingDetail> findAllByCaseId(Long bookingId);
}
