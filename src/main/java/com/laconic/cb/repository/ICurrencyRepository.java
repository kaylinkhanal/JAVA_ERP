package com.laconic.cb.repository;

import com.laconic.cb.model.Country;
import com.laconic.cb.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICurrencyRepository extends JpaRepository<Currency, Long> {
}
