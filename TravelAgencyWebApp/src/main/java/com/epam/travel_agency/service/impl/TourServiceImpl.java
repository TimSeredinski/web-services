package com.epam.travel_agency.service.impl;

import com.epam.travel_agency.dao.TourRepository;
import com.epam.travel_agency.entity.Tour;
import com.epam.travel_agency.exception.ServiceException;
import com.epam.travel_agency.service.TourService;
import com.epam.travel_agency.validation.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("tourService")
public class TourServiceImpl implements TourService {

    private final static Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

    @Autowired
    private TourRepository tourRepository;

    @Override
    @Transactional
    public Tour createTour(Tour tour) throws ServiceException {
        if (ValidationUtil.isObjectValid(tour)) {
            return tourRepository.createTour(tour);
        } else {
            logger.info("Not valid data in TourServiceImpl.createTour()");
            throw new ServiceException("Not valid data");
        }
    }

    @Override
    public Tour getTourById(int id) throws ServiceException {
        if (tourRepository.getTourById(id) == null) {
            String info = "There is no tour with id = " + id;
            logger.info(info);
            throw new ServiceException(info);
        }
        return tourRepository.getTourById(id);
    }

    @Override
    @Transactional
    public Tour updateTour(Tour tour) throws ServiceException {
        if (ValidationUtil.isObjectValid(tour)) {
            return tourRepository.updateTour(tour);
        } else {
            logger.info("Not valid data in TourServiceImpl.updateTour()");
            throw new ServiceException("Not valid data");
        }
    }

    @Override
    @Transactional
    public void deleteTour(int id) {
        tourRepository.deleteTour(id);
    }

    @Override
    public List<Tour> getAllTours(int firstNum) {
        return tourRepository.getAllTours(firstNum);
    }

}
