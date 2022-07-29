package com.example.demo.service;

import com.example.demo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl implements stateService{

    @Autowired
    StateRepository stateRepository;


}
