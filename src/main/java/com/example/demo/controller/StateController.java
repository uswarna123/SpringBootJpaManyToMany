package com.example.demo.controller;

import com.example.demo.entity.Country;
import com.example.demo.entity.State;
import com.example.demo.exception.BadRrequestException;
import com.example.demo.exception.ResourceNotFoundException;
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
   @PutMapping("/updateStateById/{Id}")
      public  ResponseEntity<State> updateStateById(@Valid @RequestBody State state,@PathVariable Long Id) {
       State state1 = stateRepository.findById(Id).orElseThrow(() -> new
               ResourceNotFoundException("No State Found With this id:" + Id));
               state1.setStateName(state.getStateName());
       Optional<Country> countryOpt = countryRepository.findById(state.getCountry().getCountryId());
      if(countryOpt.isEmpty()){
          throw new ResourceNotFoundException("No Country found with this id please check dB");
      }
      state1.setCountry(countryRepository.findById(countryOpt.get().getCountryId()).get());
       State updatedState = stateRepository.save(state1);
       return ResponseEntity.ok(updatedState) ;
   }
    @PatchMapping("/updateStateName/{Id}")
        public  ResponseEntity<State> updateStateName(@Valid @RequestBody State state,@PathVariable Long Id) {
        State state1 = stateRepository.findById(Id).orElseThrow(() -> new
                ResourceNotFoundException("No State Found With this id:" + Id));
        state1.setStateName(state.getStateName());
        State updatedStateName = stateRepository.save(state1);
        return ResponseEntity.ok(updatedStateName) ;
    }
    @DeleteMapping("/deleteAllStates")
            public String deleteAllStates(){
        stateRepository.deleteAll();
        return "All Records in state Table deleted";
    }
}
