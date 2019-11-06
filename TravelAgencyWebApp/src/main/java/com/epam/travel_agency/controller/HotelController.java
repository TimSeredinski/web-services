package com.epam.travel_agency.controller;

import com.epam.travel_agency.entity.Hotel;
import com.epam.travel_agency.exception.ServiceException;
import com.epam.travel_agency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotel")
    public ResponseEntity<List> getAll() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<Object> getByID(@PathVariable int id) {
        try {
            return new ResponseEntity<>(hotelService.getHotelById(id), HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/hotel")
    public ResponseEntity<Object> create(@RequestBody Hotel hotel) {
        try {
            return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
        } catch (ServiceException e ){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/hotel")
    public ResponseEntity<Object> update(@RequestBody Hotel hotel) {
        try {
            return new ResponseEntity<>(hotelService.updateHotel(hotel), HttpStatus.CREATED);
        } catch (ServiceException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/hotel/{id}")
    public ResponseEntity<Object> remove(@PathVariable int id) {
        hotelService.deleteHotel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
