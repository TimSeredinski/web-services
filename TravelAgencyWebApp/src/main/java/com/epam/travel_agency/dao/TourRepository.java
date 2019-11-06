package com.epam.travel_agency.dao;

import com.epam.travel_agency.entity.Tour;
import com.epam.travel_agency.entity.criteria.Criteria;

import java.util.List;

public interface TourRepository {

    Tour createTour(Tour tour);
    Tour getTourById(int id);
    Tour updateTour(Tour tour);
    void deleteTour(int id);
    List<Tour> getAllTours(int firstNum);
    List<Tour> getToursByCriteria(Criteria criteria);
    int getCountOfAllTours();
}
