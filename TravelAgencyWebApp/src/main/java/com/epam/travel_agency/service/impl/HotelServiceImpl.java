package com.epam.travel_agency.service.impl;

import com.epam.travel_agency.dao.HotelRepository;
import com.epam.travel_agency.entity.Hotel;
import com.epam.travel_agency.exception.ServiceException;
import com.epam.travel_agency.service.HotelService;
import com.epam.travel_agency.validation.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("hotelService")
public class HotelServiceImpl implements HotelService {

    private final static Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    @Transactional
    public Hotel createHotel(Hotel hotel) throws ServiceException {
        if (ValidationUtil.isObjectValid(hotel)) {
            Hotel hotelFromDB = hotelRepository.getHotelByName(hotel.getName());
            if (hotelFromDB != null) {
//                logger.info("Hotel with this name already exist");
//                throw new ServiceException();
                return hotelFromDB;
            }
            return hotelRepository.createHotel(hotel);
        } else {
            logger.info("Not valid data in UserServiceImpl.createUser()");
            throw new ServiceException("Not valid data");
        }
    }

    @Override
    public Hotel getHotelById(int id) throws ServiceException {
        if (hotelRepository.getHotelById(id) == null){
            String info = "There is no hotel with id = " + id;
            logger.info(info);
            throw new ServiceException(info);
        }
            return hotelRepository.getHotelById(id);
    }

    @Override
    public Hotel getHotelByName(String name) {
        return hotelRepository.getHotelByName(name);
    }

    @Override
    @Transactional
    public void deleteHotel(int id) {
        hotelRepository.deleteHotel(id);
    }

    @Override
    @Transactional
    public Hotel updateHotel(Hotel hotel) throws ServiceException {
        if (ValidationUtil.isObjectValid(hotel)) {
            return hotelRepository.updateHotel(hotel);
        } else {
            logger.info("Not valid data in UserServiceImpl.updateHotel()");
            throw new ServiceException("Not valid data");
        }
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.getAllHotels();
    }
}
