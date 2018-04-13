package com.sboot.sbootmod.dto;

import com.sboot.sbootmod.data.TicketData;
import com.sboot.sbootmod.dto.service.TicketService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

@Component
@Transactional
public class TicketDTO implements TicketService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void createOrUpdate(TicketData ticketData) {
        sessionFactory.getCurrentSession().saveOrUpdate(ticketData);
    }

    @Override
    public TicketData getTicketById(int id) {
        return (TicketData) sessionFactory.getCurrentSession().createQuery("FROM TicketData ticket " +
                "WHERE ticket.id=:id").setParameter("id", id).getSingleResult();
    }

    @Override
    public TicketData getTicketByCode(String code) {
        return (TicketData) sessionFactory.getCurrentSession().createQuery("FROM TicketData ticket " +
                "WHERE ticket.code=:code").setParameter("code", code).getSingleResult();
    }

    @Override
    public boolean deleteTicketById(int id) {
        return sessionFactory.getCurrentSession().createQuery("DELETE TicketData WHERE id = :id")
                .setParameter("id", id).executeUpdate() > 0;
    }
}
