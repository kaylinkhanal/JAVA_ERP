package com.laconic.cb.repository;

import com.laconic.cb.model.Site;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiteRepository extends JpaRepository<Site, Long> {
    Page<Site> findAll(Pageable pageable);
}
