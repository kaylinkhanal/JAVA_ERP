package com.laconic.cb.repository;

import com.laconic.cb.model.DepositDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepositDetailRepository extends JpaRepository<DepositDetail, Long> {
}
