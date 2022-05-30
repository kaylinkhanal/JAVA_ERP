package com.laconic.cb.service.impl;

import com.laconic.cb.model.Country;
import com.laconic.cb.repository.ICountryRepository;
import com.laconic.cb.service.ICountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService {

    private final ICountryRepository countryRepository;

    public CountryService(ICountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
