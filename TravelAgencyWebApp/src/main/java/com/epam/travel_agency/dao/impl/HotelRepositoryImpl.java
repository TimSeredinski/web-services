package com.epam.travel_agency.dao.impl;

import com.epam.travel_agency.dao.HotelRepository;
import com.epam.travel_agency.entity.Hotel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class HotelRepositoryImpl implements HotelRepository {

    private final static Logger logger = LoggerFactory.getLogger(HotelRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return em.merge(hotel);
    }

    @Override
    public Hotel getHotelById(int id) {
        try {
            return em.find(Hotel.class, id);
        } catch (NoResultException e) {
            logger.info("There is no such data in hotel table");
            return null;
        }
    }

    @Override
    public Hotel getHotelByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Hotel> query = builder.createQuery(Hotel.class);
        Root<Hotel> root = query.from(Hotel.class);
        query.select(root).where(builder.equal(root.get("name"), name));
        try {
            return em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            logger.info("There is no such data in hotel table");
            return null;
        }
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        return em.merge(hotel);
    }

    @Override
    public void deleteHotel(int id) {
        Hotel hotel = getHotelById(id);
        if (hotel != null) {
            em.remove(hotel);
        }
    }

    @Override
    public List<Hotel> getAllHotels() {
        CriteriaQuery<Hotel> criteriaQuery = em.getCriteriaBuilder().createQuery(Hotel.class);
        @SuppressWarnings("unused")
        Root<Hotel> root = criteriaQuery.from(Hotel.class);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
