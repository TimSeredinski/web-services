package com.epam.travel_agency.service;

import com.epam.travel_agency.entity.Tour;
import com.epam.travel_agency.entity.criteria.Criteria;
import com.epam.travel_agency.exception.ServiceException;

import java.util.List;

public interface TourService {

    Tour createTour(Tour tour) throws ServiceException;
    Tour getTourById(int id) throws ServiceException;
    Tour updateTour(Tour tour) throws ServiceException;
    void deleteTour(int id);
    List<Tour> getAllTours(int firstNum);

}
