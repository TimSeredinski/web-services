package com.epam.travel_agency.dao.impl;

import com.epam.travel_agency.dao.TourRepository;
import com.epam.travel_agency.entity.Tour;
import com.epam.travel_agency.entity.criteria.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class TourRepositoryImpl implements TourRepository {

    private final static Logger logger = LoggerFactory.getLogger(TourRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Tour createTour(Tour tour) {
        return em.merge(tour);
    }

    @Override
    public Tour getTourById(int id) {
        try {
            return em.find(Tour.class, id);
        } catch (NoResultException e) {
            logger.info("There is no such data in tour table");
            return null;
        }
    }

    @Override
    public Tour updateTour(Tour tour) {
        return em.merge(tour);
    }

    @Override
    public void deleteTour(int id) {
        Tour tour = getTourById(id);
        if (tour != null) {
            em.remove(tour);
        }
    }

    @Override
    public List<Tour> getAllTours(int firstNum) {
        int pageSize = 2;
        CriteriaQuery<Tour> criteriaQuery = em.getCriteriaBuilder().createQuery(Tour.class);

        @SuppressWarnings("unused")
        Root<Tour> root = criteriaQuery.from(Tour.class);
        Query query = em.createQuery(criteriaQuery);
        query.setFirstResult(firstNum);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public List<Tour> getToursByCriteria(Criteria criteria) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tour> criteriaQuery = cb.createQuery(Tour.class);
        Root<Tour> root = criteriaQuery.from(Tour.class);

        List<Predicate> predicates = new ArrayList<>();
        Iterator iteratorForKeys = criteria.getCriteria().keySet().iterator();
        Iterator iteratorForValues = criteria.getCriteria().values().iterator();
        while (iteratorForKeys.hasNext()) {
            String key = iteratorForKeys.next().toString().toLowerCase();
            predicates.add(cb.equal(root.get(key), iteratorForValues.next()));
        }
        try {
            criteriaQuery.select(root).where(predicates.toArray(new Predicate[]{}));
            return em.createQuery(criteriaQuery).getResultList();
        } catch (NoResultException e) {
            logger.info("There is no such data in user_account table");
            return null;
        }
    }

    @Override
    public int getCountOfAllTours() {
        CriteriaQuery<Tour> criteriaQuery = em.getCriteriaBuilder().createQuery(Tour.class);
        @SuppressWarnings("unused")
        Root<Tour> root = criteriaQuery.from(Tour.class);
        Query query = em.createQuery(criteriaQuery);
        return query.getResultList().size();
    }
}
