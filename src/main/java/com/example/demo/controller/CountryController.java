package com.example.demo.controller;

import com.example.demo.entity.Country;
import com.example.demo.entity.State;
import com.example.demo.exception.BadRrequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @PostMapping("/addCountry")
    public ResponseEntity<Country> addCountry(@Valid @RequestBody Country country) {
          country.setCountryName(country.getCountryName());
          if (country.getCountryName().isEmpty())
          {
              throw new ResourceNotFoundException("Please provide Country Name");
          }
        Country newCountry = countryRepository.save(country);
        return ResponseEntity.ok(newCountry);
    }
    @PutMapping("/updateCountryById/{Id}")
    public  ResponseEntity<Country> updateCountryById(@Valid @RequestBody Country country,@PathVariable Long Id) {
        Country country1= countryRepository.findById(Id).orElseThrow(() -> new
                ResourceNotFoundException("No Country Found With this id:" + Id));
        country1.setCountryName(country.getCountryName());
        if(country.getCountryName().isEmpty()){
            throw new ResourceNotFoundException("Please provide Country Name");
        }
        Country updatedCountry = countryRepository.save(country1);
        return ResponseEntity.ok(updatedCountry) ;
    }
    @PatchMapping("/updateCountryName/{Id}")
    public  ResponseEntity<Country> updateCountryName(@Valid @RequestBody Country country,@PathVariable Long Id) {
        Country country1 = countryRepository.findById(Id).orElseThrow(() -> new
                ResourceNotFoundException("No Country Found With this id:" + Id));
        country1.setCountryName(country.getCountryName());
        Country updatedCountryName = countryRepository.save(country1);
        return ResponseEntity.ok(updatedCountryName) ;
    }
    @DeleteMapping("/deleteAllCountries")
    public String deleteAllCountries(){
        countryRepository.deleteAll();
        return "All Records in Country Table deleted";
    }

}
