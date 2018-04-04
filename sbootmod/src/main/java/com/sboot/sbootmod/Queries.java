package com.sboot.sbootmod;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mateusz Krok on 2018-04-03
 */

@Component
@Transactional
public class Queries implements DBQuery {

    @Autowired
    SessionFactory sf;

    @Override
    public String getName(String name) {
        return sf.getCurrentSession().createQuery("SELECT name FROM ClientData cd WHERE cd.name=:name").setParameter("name", name).getSingleResult().toString();
    }

    @Override
    public void ge(Object o){
        sf.getCurrentSession().save(o);
    }

}
