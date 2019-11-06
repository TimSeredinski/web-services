package com.epam.travel_agency.service;

import com.epam.travel_agency.entity.Country;
import com.epam.travel_agency.exception.ServiceException;

import java.util.List;

public interface CountryService {

    Country createCountry(Country country) throws ServiceException;
    Country getCountryById(int id) throws ServiceException;
    void deleteCountry(int id);
    Country updateCountry(Country country) throws ServiceException;
    List<Country> getAllCountries();

}
