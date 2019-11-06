package com.epam.travel_agency.dao.impl;

import com.epam.travel_agency.dao.UserRepository;
import com.epam.travel_agency.entity.Tour;
import com.epam.travel_agency.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.Set;


@Repository
public class  UserRepositoryImpl implements UserRepository {

    private final static Logger logger = LoggerFactory.getLogger(CountryRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public User createUser(User user) {
        return em.merge(user);
    }

    @Override
    public User getUserById(int id) {
        try {
            return em.find(User.class, id);
        } catch (NoResultException e) {
            logger.info("There is no such data in user_account table");
            return null;
        }
    }

    @Override
    public User getUserByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        ParameterExpression<String> nameParameter = cb.parameter(String.class, "login");
        criteriaQuery.select(root).where(cb.equal(root.get("login"), nameParameter));
        try {
            return em.createQuery(criteriaQuery).setParameter("login", name).getSingleResult();
        } catch (NoResultException e) {
            logger.info("There is no such data in user_account table");
            return null;
        }
    }

    @Override
    public User updateUser(User user) {
        return em.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = getUserById(id);
        if (user != null) {
            em.remove(user);
        }
    }

}
