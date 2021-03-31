package com.exam.exam.service;
import com.exam.exam.model.Country;

public interface ICountryService {
    Iterable<Country> findAll();
    Country findById(Long id);
    void  save(Country country);
    void remove(Long id);
}
