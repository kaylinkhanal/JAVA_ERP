package com.laconic.cb.service.impl;

import com.laconic.cb.model.Country;
import com.laconic.cb.model.Currency;
import com.laconic.cb.repository.ICurrencyRepository;
import com.laconic.cb.service.ICountryService;
import com.laconic.cb.service.ICurrencyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService implements ICurrencyService {

    private final ICurrencyRepository currencyRepository;

    public CurrencyService(ICurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }


    @Override
    public List<Currency> getAllCurrencies() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency findById(Long id) {
        return currencyRepository.findById(id).get();
    }
}
