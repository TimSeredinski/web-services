package com.epam.travel_agency.dao;

import com.epam.travel_agency.entity.Hotel;

import java.util.List;

public interface HotelRepository {

    Hotel createHotel(Hotel hotel);
    Hotel getHotelById(int id);
    Hotel getHotelByName(String name);
    Hotel updateHotel(Hotel hotel);
    void deleteHotel(int id);
    List<Hotel> getAllHotels();

}
