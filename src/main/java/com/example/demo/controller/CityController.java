package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CityRepository;
import com.example.demo.service.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CityController {
    @Autowired
    CityServiceImpl cityService;
    @Autowired
    CityRepository cityRepository;

    @GetMapping("/findAllCities")
    public ResponseEntity<List<City>> findAllCities(){
       List<City> cities= cityRepository.findAll();
        return ResponseEntity.ok(cities);
    }
    @PostMapping("/addCity")
    public ResponseEntity<City> addCity(@Valid @RequestBody City city) {
        city.setCityName(city.getCityName());
        if (city.getCityName().isEmpty())
        {
            throw new ResourceNotFoundException("Please provide City Name");
        }
        city.setZipCode(city.getZipCode());
        City newCity = cityRepository.save(city);
        return ResponseEntity.ok(newCity);
    }
    @PutMapping("/updateCityById/{Id}")
    public  ResponseEntity<City> updateCityById(@Valid @RequestBody City city,@PathVariable Long Id) {
        City city1= cityRepository.findById(Id).orElseThrow(() -> new
                ResourceNotFoundException("No City Found With this id:" + Id));
        city1.setCityName(city.getCityName());
        if(city.getCityName().isEmpty()){
            throw new ResourceNotFoundException("Please provide City Name");
        }
        City updatedCity = cityRepository.save(city1);
        return ResponseEntity.ok(updatedCity) ;
    }
    @PatchMapping("/updateCityName/{Id}")
    public  ResponseEntity<City> updateCityName(@Valid @RequestBody City city,@PathVariable Long Id) {
        City city1 = cityRepository.findById(Id).orElseThrow(() -> new
                ResourceNotFoundException("No City Found With this id:" + Id));
        city1.setCityName(city.getCityName());
        City updatedCityName = cityRepository.save(city1);
        return ResponseEntity.ok(updatedCityName) ;
    }
    @DeleteMapping("/deleteAllCities")
    public String deleteAllCities(){
        cityRepository.deleteAll();
        return "All Records in City Table deleted";
    }

}
