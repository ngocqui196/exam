package com.exam.exam.formater;

import com.exam.exam.model.Country;
import com.exam.exam.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CountryFormatter implements Formatter<Country> {
    private ICountryService countryService;


    @Autowired
    public CountryFormatter(ICountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public Country parse(String text, Locale locale){
        Country country = new Country();
        try {
            country = countryService.findById(Long.parseLong(text));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public String print(Country object, Locale locale) {
        return "[" + object.getId() + ", " + object.getName() + "]";
    }
}
