package com.epam.travel_agency.service.impl;

import com.epam.travel_agency.dao.CountryRepository;
import com.epam.travel_agency.entity.Country;
import com.epam.travel_agency.exception.ServiceException;
import com.epam.travel_agency.service.CountryService;
import com.epam.travel_agency.validation.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final static Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);


    @Autowired
    private CountryRepository countryRepository;

    @Override
    @Transactional
    public Country createCountry(Country country) throws ServiceException {
        if (ValidationUtil.isObjectValid(country)) {
            Country countryFromDB = countryRepository.getCountryByName(country.getName());
            if (countryFromDB != null) {
//                logger.info("Country with this name already exist");
//                throw new ServiceException();
                return countryFromDB;
            }
            return countryRepository.createCountry(country);
        } else {
            logger.info("Not valid data in CountryServiceImpl.createCountry()");
            throw new ServiceException("Not valid data");
        }
    }

    @Override
    public Country getCountryById(int id) throws ServiceException{
        if(countryRepository.getCountryById(id) == null){
            String info = "There is no country with id = " + id;
            logger.info(info);
            throw new ServiceException(info);
        }
        return countryRepository.getCountryById(id);
    }

    @Override
    @Transactional
    public void deleteCountry(int id) {
        countryRepository.deleteCountry(id);
    }

    @Override
    @Transactional
    public Country updateCountry(Country country) throws ServiceException {
        if (ValidationUtil.isObjectValid(country)) {
            Country countryFromDB = countryRepository.getCountryByName(country.getName());
            if (countryFromDB != null) {
                logger.info("Country with this name already exist");
                throw new ServiceException("Country with this name already exist");
            }
            return countryRepository.updateCountryById(country);
        } else {
            logger.info("Not valid data in CountryServiceImpl.updateCountry()");
            throw new ServiceException("Not valid data");
        }
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.getAllCountries();
    }
}
