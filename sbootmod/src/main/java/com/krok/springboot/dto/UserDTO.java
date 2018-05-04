package com.krok.springboot.dto;

import com.krok.data.UserData;
import com.krok.springboot.dto.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

@Component
@Transactional
public class UserDTO implements UserService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void createOrUpdate(UserData userData) {
        sessionFactory.getCurrentSession().saveOrUpdate(userData);
    }

    @Override
    public UserData getUserById(int id) {
        return (UserData) sessionFactory.getCurrentSession().createQuery("FROM UserData user WHERE user.id=:id")
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public boolean deleteUserById(int id) {
        return sessionFactory.getCurrentSession().createQuery("DELETE UserData WHERE id = :id")
                .setParameter("id", id).executeUpdate() > 0;
    }
}
