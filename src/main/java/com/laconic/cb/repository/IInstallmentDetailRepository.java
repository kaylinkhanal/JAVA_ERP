package com.laconic.cb.repository;

import com.laconic.cb.model.InstallmentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstallmentDetailRepository extends JpaRepository<InstallmentDetail, Long> {
}
