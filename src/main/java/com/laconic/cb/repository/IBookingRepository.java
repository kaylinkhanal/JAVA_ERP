package com.laconic.cb.repository;

import com.laconic.cb.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findByCaseDto_CaseId(Long caseId);
    List<Booking> findAllByCaseDto_CaseId(Long caseId);
}
