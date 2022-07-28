package com.example.demo.data;

import com.example.demo.entity.City;
import com.example.demo.repository.cityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CityDataTableLoader implements ApplicationRunner {
    @Autowired
    cityRepository cityRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
      //  addRecordToCityTable();
    }
    public void addRecordToCityTable()
    {
         City city=new City();
         city.setCityName("Hyderabad");
         city.setZipCode(500001);
        cityRepository.save(city);
        System.out.println("Data Added to City Table");
    }

}
