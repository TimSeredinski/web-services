package com.epam.travel_agency.controller;

import com.epam.travel_agency.entity.Tour;
import com.epam.travel_agency.exception.ServiceException;
import com.epam.travel_agency.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class TourController {

    @Autowired
    private TourService tourService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping(path = "/tour/{id}")
    public ResponseEntity<Object> getByID(@PathVariable int id) {
        try {
            return new ResponseEntity<>(tourService.getTourById(id), HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/tour", params = {"page"})
    public ResponseEntity<Object> viewAllTours(@Param("page") int page) {
        return new ResponseEntity<>(tourService.getAllTours(page), HttpStatus.OK);
    }

    @PostMapping(value = "/tour")
    public ResponseEntity<Object> create(@RequestBody Tour tour) {
        try {
            return new ResponseEntity<>(tourService.createTour(tour), HttpStatus.CREATED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/tour/{id}")
    public ResponseEntity<Tour> deleteTour(@PathVariable int id) {
        tourService.deleteTour(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/tour")
    public ResponseEntity<Object> updateTour(@RequestBody Tour tour) {
        try {
            return new ResponseEntity<>(tourService.updateTour(tour), HttpStatus.CREATED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

}

