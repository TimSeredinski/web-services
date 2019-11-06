package com.epam.travel_agency.service;

import com.epam.travel_agency.entity.Tour;
import com.epam.travel_agency.entity.User;
import com.epam.travel_agency.exception.ServiceException;

import java.util.Set;

public interface UserService {

    User createUser(User user) throws ServiceException;
    User getUserById(int id);
    User getUserByName(String name);
    User updateUser(User user) throws ServiceException;
    void deleteUser(int id);
}
