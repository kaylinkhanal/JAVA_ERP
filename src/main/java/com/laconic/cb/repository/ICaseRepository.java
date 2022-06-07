package com.laconic.cb.repository;

import com.laconic.cb.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICaseRepository extends JpaRepository<Case, Long> {
}
