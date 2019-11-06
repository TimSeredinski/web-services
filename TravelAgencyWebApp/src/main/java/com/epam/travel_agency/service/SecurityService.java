package com.epam.travel_agency.service;

public interface SecurityService {

    String findLoggedUserName();

    void autoLogin(String username, String password);

}
