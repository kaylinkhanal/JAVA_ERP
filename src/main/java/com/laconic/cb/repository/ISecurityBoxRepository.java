package com.laconic.cb.repository;

import com.laconic.cb.model.SecurityBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISecurityBoxRepository extends JpaRepository<SecurityBox, Long> {
    Optional<SecurityBox> findBySecurityBoxId(Long securityBoxId);
}
