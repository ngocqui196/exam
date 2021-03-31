package com.exam.exam.service;

import com.exam.exam.model.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {
        List<City> findAll();
        City findById(Long id);
        void  save(City city);
        void remove(Long id);
}
