package com.example.demo.service;

import com.example.demo.repository.cityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements cityService{

    @Autowired
    cityRepository cityRepository;

}
