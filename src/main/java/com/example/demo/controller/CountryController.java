package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import com.example.demo.repository.countryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    countryRepository countryRepository;

    @GetMapping("/findAllCountries")
    public List<Country> findAllCountries() {return countryRepository.findAll();}


}
