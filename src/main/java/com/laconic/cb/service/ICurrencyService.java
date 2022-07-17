package com.laconic.cb.service;

import com.laconic.cb.model.Country;
import com.laconic.cb.model.Currency;

import java.util.List;

public interface ICurrencyService {
    List<Currency> getAllCurrencies();
    Currency findById(Long id);
}
