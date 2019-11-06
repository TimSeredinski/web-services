package com.epam.travel_agency.service.impl;

import com.epam.travel_agency.dao.UserRepository;
import com.epam.travel_agency.entity.Role;
import com.epam.travel_agency.entity.Tour;
import com.epam.travel_agency.entity.User;
import com.epam.travel_agency.exception.ServiceException;
import com.epam.travel_agency.service.UserService;
import com.epam.travel_agency.validation.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public User createUser(User user) throws ServiceException {
        if (ValidationUtil.isObjectValid(user)) {
            User userFromDB = userRepository.getUserByName(user.getLogin());
            if (userFromDB != null) {
//                logger.info("User with this name already exist");
//                throw new ServiceException();
                return userFromDB;
            }
            User newUser = new User(user.getLogin(), bCryptPasswordEncoder.encode(user.getPassword()));
            Set<Role> roles = new HashSet<>();
            roles.add(new Role(2, "ROLE_MEMBER"));
            newUser.setRoles(roles);
            return userRepository.createUser(newUser);
        } else {
            logger.info("Not valid data in UserServiceImpl.createUser()");
            throw new ServiceException("Not valid data");
        }
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.getUserByName(name);
    }

    @Override
    @Transactional
    public User updateUser(User user) throws ServiceException {
        if (ValidationUtil.isObjectValid(user)) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.updateUser(user);
        } else {
            logger.info("Not valid data in UserServiceImpl.updateUser()");
            throw new ServiceException("Not valid data");
        }
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

}
