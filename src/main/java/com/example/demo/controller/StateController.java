package com.example.demo.controller;

import com.example.demo.entity.State;
import com.example.demo.repository.stateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StateController {
    @Autowired
    stateRepository stateRepository;

    @GetMapping("/findAllStates")
   public List<State> findAllStates(){return stateRepository.findAll();}
}
