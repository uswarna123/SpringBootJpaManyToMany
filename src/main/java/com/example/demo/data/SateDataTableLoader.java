package com.example.demo.data;

import com.example.demo.entity.State;
import com.example.demo.repository.stateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SateDataTableLoader implements ApplicationRunner {
    @Autowired
    stateRepository stateRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

      //  addDataToStateTable();

    }
    public  void addDataToStateTable()
    {
        State state=new State();
        state.setStateName("Telangana");
        stateRepository.save(state);
        System.out.println("Data Inserted To State Table");

    }
}
