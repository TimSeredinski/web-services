package com.epam.travel_agency.controller;

import com.epam.travel_agency.entity.User;
import com.epam.travel_agency.exception.ServiceException;
import com.epam.travel_agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/registration")
    public ResponseEntity<Object> registration(@RequestBody User userForm) {
        try {
            return new ResponseEntity<>(userService.createUser(userForm), HttpStatus.CREATED);
        } catch (ServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}

