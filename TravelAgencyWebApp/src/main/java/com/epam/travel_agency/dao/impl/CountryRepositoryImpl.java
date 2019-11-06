package com.epam.travel_agency.dao.impl;

import com.epam.travel_agency.dao.CountryRepository;
import com.epam.travel_agency.entity.Country;
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
public class CountryRepositoryImpl implements CountryRepository {

    private final static Logger logger = LoggerFactory.getLogger(CountryRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public Country createCountry(Country country) {
        return em.merge(country);
    }

    @Override
    public Country getCountryById(int id) {
        try {
            return em.find(Country.class, id);
        } catch (NoResultException e) {
            logger.info("There is no such data in country table");
            return null;
        }
    }

    @Override
    public Country getCountryByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Country> query = builder.createQuery(Country.class);
        Root<Country> root = query.from(Country.class);
        query.select(root).where(builder.equal(root.get("name"), name));
        try {
            return em.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            logger.info("There is no such data in country table");
            return null;
        }
    }

    @Override
    public Country updateCountryById(Country country) {
            return em.merge(country);
    }

    @Override
    public void deleteCountry(int id) {
        Country country = getCountryById(id);
        if (country != null) {
            em.remove(country);
        }
    }

    @Override
    public List<Country> getAllCountries() {
        CriteriaQuery<Country> criteriaQuery = em.getCriteriaBuilder().createQuery(Country.class);
        @SuppressWarnings("unused")
        Root<Country> root = criteriaQuery.from(Country.class);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
