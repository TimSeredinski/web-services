package com.epam.travel_agency.dao;

import com.epam.travel_agency.entity.Tour;
import com.epam.travel_agency.entity.User;

import java.util.Set;

public interface UserRepository {

    User createUser(User user);
    User getUserById(int id);
    User getUserByName(String name);
    User updateUser(User user);
    void deleteUser(int id);
}
