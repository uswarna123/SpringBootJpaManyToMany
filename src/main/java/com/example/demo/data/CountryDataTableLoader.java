package com.example.demo.data;

import com.example.demo.entity.Country;
import com.example.demo.repository.countryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CountryDataTableLoader implements ApplicationRunner {

    @Autowired
    countryRepository countryRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
    //  addDataToCountryTable();
    }

    public void addDataToCountryTable()
    {
        Country country=new Country();
        country.setCountryName("India");
        countryRepository.save(country);
        System.out.println("Data inserted in Country Table");
    }
}
