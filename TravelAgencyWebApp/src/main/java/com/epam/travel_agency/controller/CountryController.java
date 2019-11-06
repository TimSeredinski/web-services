package com.epam.travel_agency.controller;

import com.epam.travel_agency.entity.Country;
import com.epam.travel_agency.exception.ServiceException;
import com.epam.travel_agency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public ResponseEntity<List> getAll() {
        List<Country> countries = countryService.getAllCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("/country/{id}")
    public ResponseEntity<Object> getByID(@PathVariable int id) {
        try {
            return new ResponseEntity<>(countryService.getCountryById(id), HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping("/country")
    public ResponseEntity<Object> create(@RequestBody Country country) {
        try {
            return new ResponseEntity<>(countryService.createCountry(country), HttpStatus.CREATED);
        } catch (ServiceException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/country")
    public ResponseEntity<Object> update(@RequestBody Country country) {
        try {
            return new ResponseEntity<>(countryService.updateCountry(country), HttpStatus.CREATED);
        } catch (ServiceException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/country/{id}")
    public ResponseEntity<Object> remove(@PathVariable int id) {
        countryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

