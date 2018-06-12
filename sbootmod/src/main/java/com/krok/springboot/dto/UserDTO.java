package com.krok.springboot.dto;

import com.krok.data.UserData;
import com.krok.data.UserRoleData;
import com.krok.error.AppException;
import com.krok.error.DAOError;
import com.krok.springboot.dto.service.UserService;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

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
            UserRoleData userRoleData = new UserRoleData();
            userRoleData.setRole("ROLE_USER");
            userRoleData.setUserData(userData);
            int i = (int) sessionFactory.getCurrentSession().save(userData);
            sessionFactory.getCurrentSession().save(userRoleData);
            System.out.println("\nRegistered, id: " + i);
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
    public UserData getUserByLogin(UserData userData) throws AppException {
        try {
            UserData user = (UserData) sessionFactory.getCurrentSession().createQuery("FROM UserData user WHERE user.login=:login")
                    .setParameter("login", userData.getLogin()).getSingleResult();
                return user;
        } catch (NoResultException e) {
            throw new AppException(DAOError.LOGIN_NOT_FOUND, userData.getLogin());
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public UserData getUserToLogin(String login) {

        List<UserData> users;

        users = sessionFactory.getCurrentSession()
                .createQuery("from UserData where login=:login").setParameter("login", login).list();

        if (users.size() > 0) {
            System.out.println("AUTORYZACJA Zwracam: " + users.get(0).getLogin());
            return users.get(0);
        } else {
            System.out.println("AUTORYZACJA BRAK NICKU! ");
            return null;
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
