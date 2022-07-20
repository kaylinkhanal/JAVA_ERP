package com.laconic.cb.repository;

import com.laconic.cb.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByCaseId(Long caseId);
    List<Booking> findAllByCaseId(Long caseId);
    Optional<Booking> findByBookingId(Long bookingId);
}
