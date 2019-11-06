package com.epam.travel_agency.service.impl;

import com.epam.travel_agency.service.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class SecutityServiceImpl implements SecurityService {

    private final static Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

    private UserDetailsService userDetailsService = new UserDetailsServiceImpl();

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String findLoggedUserName() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }

    @Override
    public void autoLogin(String username, String password) {
        System.out.println(username + "   " + password);
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        authenticationManager.authenticate(authenticationToken);

        if (authenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            logger.debug(String.format("Successfully %s auto logged in", username));
        }
    }
}