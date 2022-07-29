package com.example.demo.controller;

import com.example.demo.entity.Country;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;

@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/findAllCountries")
    public ResponseEntity<List<Country>> findAllCountries() {
        LOGGER.info("Begining findAllCountries()");
        List<Country> country = countryRepository.findAll();
        return ResponseEntity.ok(country);

    }

    @GetMapping("/findCountryById/{id}")
    public ResponseEntity<Country> findById(@PathVariable("id") Long id) {
        LOGGER.info("Calling findById");
        Optional<Country> countryOptional = countryRepository.findById(id);

        if(countryOptional.isEmpty()) {
            throw new ResourceNotFoundException("Country is not found by Id ["+id+"]");
        }
       Country country =  countryOptional.get();
       LOGGER.info("Country >>> ",country);


          return ResponseEntity.ok(country);
    }

}
