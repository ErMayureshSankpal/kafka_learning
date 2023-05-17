package com.kafkalearning.repo;

import com.kafkalearning.model.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Countries, String> {

    Countries findByCountryName(String countryName);
    Countries findByRegionIdAndCountryName(long regionId, String countryName);
}
