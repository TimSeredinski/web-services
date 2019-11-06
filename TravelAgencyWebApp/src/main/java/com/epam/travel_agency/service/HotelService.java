package com.epam.travel_agency.service;

import com.epam.travel_agency.entity.Hotel;
import com.epam.travel_agency.exception.ServiceException;

import java.util.List;

public interface HotelService {

    Hotel createHotel(Hotel hotel) throws ServiceException;
    Hotel getHotelById(int id) throws ServiceException;
    Hotel getHotelByName(String name);
    Hotel updateHotel(Hotel hotel) throws ServiceException;
    void deleteHotel(int id);
    List<Hotel> getAllHotels();

}
