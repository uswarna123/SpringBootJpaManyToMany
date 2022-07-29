package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.repository.CityRepository;
import com.example.demo.service.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/addNewCity/{city}")
    public void addCity(){
   //cityRepository.finfByNmae(String cityname);
    }

}
