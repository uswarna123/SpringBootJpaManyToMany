package com.example.demo.service;

import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements countryService{

@Autowired
CountryRepository countryRepository;

}
