package com.example.demo.controller;

import com.example.demo.entity.Country;
import com.example.demo.entity.State;
import com.example.demo.exception.BadRrequestException;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class StateController {
    @Autowired
    private StateRepository stateRepository;
    @Autowired
   private CountryRepository countryRepository;
    @GetMapping("/findAllStates")
   public ResponseEntity<List<State>> findAllStates(){
       List<State> state=stateRepository.findAll();
        return ResponseEntity.ok(state);
    }
    @PostMapping("/addState")
    public ResponseEntity<State> addState(@Valid @RequestBody State state) {

        Optional<Country> countryOpt = countryRepository.findById(state.getCountry().getCountryId());
        if(countryOpt.isEmpty()) {
            throw new BadRrequestException("Country Id is not valid. Please verify Country Entity in the DB");
        }
       return ResponseEntity.ok(stateRepository.save(state));

    }
   @PostMapping("/addNewState")
    public  ResponseEntity<State> addNewState(@RequestBody State state){


       return null;
   }
}
