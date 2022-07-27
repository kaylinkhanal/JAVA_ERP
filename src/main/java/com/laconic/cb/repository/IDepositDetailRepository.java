package com.laconic.cb.repository;

import com.laconic.cb.model.DepositDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IDepositDetailRepository extends JpaRepository<DepositDetail, Long> {
//    @Query(value = "update DEPOSIT_DETAIL set IS_DELETED = 1 where DEPOSIT_ID=:depositId", nativeQuery = true)
//    @Modifying
//    @Transactional
//    void softDeleteDepositDetail(Long depositId);

    @Modifying
    @Transactional
    void deleteByDepositDetailId(Long id);
}
