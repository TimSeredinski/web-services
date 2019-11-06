package com.epam.travel_agency.dao;

import com.epam.travel_agency.entity.Country;

import java.util.List;

public interface CountryRepository {
//    @Query(value = "select * from country", nativeQuery = true)

    Country createCountry(Country country);
    Country getCountryById(int id);
    Country getCountryByName(String name);
    Country updateCountryById(Country country);
    void deleteCountry(int id);
    List<Country> getAllCountries();

}
