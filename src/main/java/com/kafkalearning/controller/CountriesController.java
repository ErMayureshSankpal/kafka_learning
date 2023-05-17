package com.kafkalearning.controller;

import com.kafkalearning.model.Countries;
import com.kafkalearning.repo.CountryRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountriesController {

    private static final Logger log = LogManager.getLogger(CountriesController.class);


    @Value("${spring.application.name}")
    String appName;

    @Autowired
    CountryRepo countryRepo;


    @PostMapping("/addCountry")
    public Countries addCountry(@RequestBody Countries countries){
        log.info("Entering into CountriesController.addCountry(@RequestBody Countries countries), country name - {} Added.",countries.getCountryName());
        kafkaProducer.sendMsg(countries.toString());
        return countryRepo.save(countries);
    }
}
