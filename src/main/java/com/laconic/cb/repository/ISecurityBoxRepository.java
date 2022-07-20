package com.laconic.cb.repository;

import com.laconic.cb.model.SecurityBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISecurityBoxRepository extends JpaRepository<SecurityBox, Long> {
}
