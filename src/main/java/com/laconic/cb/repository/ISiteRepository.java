package com.laconic.cb.repository;

import com.laconic.cb.model.Site;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ISiteRepository extends JpaRepository<Site, Long> {
    Page<Site> findAll(Pageable pageable);

    @Query(value = "update SITE set IS_DELETED = 1 where SITE_ID=:siteId", nativeQuery = true)
    @Modifying
    @Transactional
    void softDeleteSite(Long siteId);

    Optional<Site> findBySiteIdAndIsDeletedFalse(Long siteId);

    Page<Site> findAllByIsDeletedFalse(Pageable pageable);
    Page<Site> findAllByIsDeletedFalseAndCustomer_CustomerId(Pageable pageable, Long customerId);
    List<Site> findAllByIsDeletedFalse();

    long countByIsDeletedFalse();
}
