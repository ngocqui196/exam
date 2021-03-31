package com.exam.exam.controller;

import com.exam.exam.model.City;
import com.exam.exam.model.Country;
import com.exam.exam.service.CityServiceImpl;
import com.exam.exam.service.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CityController {

    @Autowired
    private CityServiceImpl iCityService;

    @Autowired
    private CountryServiceImpl countryService;

    @ModelAttribute("country")
    public Iterable<Country> countries(){
        return countryService.findAll();
    }

    @GetMapping(value = "/create-city")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create-city")
    public ModelAndView saveCity(@Validated @ModelAttribute("city") City city, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView("/create");
        if (!bindingResult.hasFieldErrors()) {
            iCityService.save(city);
            modelAndView.addObject("city", new City());
            modelAndView.addObject("message", "New city created successfully");
        }

        return modelAndView;
    }
    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable(value = "id") Long id) {
        ModelAndView mav = new ModelAndView("/detail","city",iCityService.findById(id));
        return mav;
    }

    @GetMapping("/city")
    public ModelAndView listCity() {
        Iterable<City> citys = iCityService.findAll();
        List<Country> countries = (List<Country>) countryService.findAll();

        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("city", citys);
        modelAndView.addObject("country", countries );
        return modelAndView;
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable(value = "id") Long id) {
        City city = iCityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit","city", city);
        return modelAndView;
    }

    @PostMapping("/edit-city")
    public ModelAndView updateCity(@ModelAttribute("city") City city) {
        iCityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "City updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        City city = iCityService.findById(id);
        if (city != null) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("city", city);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-city")
    public String deleteCity(@ModelAttribute("city") City city) {
        iCityService.remove(city.getId());
        return "redirect:city";
    }
}