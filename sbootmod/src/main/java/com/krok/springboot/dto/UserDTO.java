package com.krok.springboot.dto;

import com.krok.data.UserData;
import com.krok.error.AppException;
import com.krok.error.DAOError;
import com.krok.springboot.dto.service.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

@Component
@Transactional
public class UserDTO implements UserService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void createOrUpdate(UserData userData) throws AppException {
        if (isUniqueLogin(userData)) {
            int i = (int) sessionFactory.getCurrentSession().save(userData);
            System.out.println("\n\n==========Nowy id to: " + i);
        } else {
            throw new AppException(DAOError.LOGIN_IS_NOT_UNIQUE, userData.getLogin());
        }

    }

    @Override
    public UserData getUserById(int id) {
        return (UserData) sessionFactory.getCurrentSession().createQuery("FROM UserData user WHERE user.id=:id")
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public UserData getUserByLogin(String login) throws AppException {
        try {
            UserData user = (UserData) sessionFactory.getCurrentSession().createQuery("FROM UserData user WHERE user.login=:login")
                    .setParameter("login", login).getSingleResult();
            return user;
        } catch (NoResultException e) {
            throw new AppException(DAOError.LOGIN_NOT_FOUND, login);
        }
    }

    @Override
    public boolean deleteUserById(int id) {
        return sessionFactory.getCurrentSession().createQuery("DELETE UserData WHERE id = :id")
                .setParameter("id", id).executeUpdate() > 0;
    }

    public boolean isUniqueLogin(UserData userData) {
        Query query;
        query = sessionFactory.getCurrentSession().createQuery("FROM UserData user WHERE user.login=:login")
                .setParameter("login", userData.getLogin());
        return query.getResultList().size() == 0;
    }
}
