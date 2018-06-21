package com.krok.springboot.dao;

import com.krok.data.TicketData;
import com.krok.springboot.dao.service.TicketService;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

@Component
@Transactional
public class TicketDAO implements TicketService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public int sendScannedData(TicketData ticketData) {
        if (checkIfExist(ticketData) != 0) {
            return ticketData.getId();
        }
        sessionFactory.getCurrentSession().save(ticketData);
        return ticketData.getId();
    }

    private int checkIfExist(TicketData ticketData) {
        Query query = sessionFactory.getCurrentSession().createQuery("select t.id from TicketData t where t.code = :code");
        query.setParameter("code", ticketData.getCode());
//        TicketData t = (TicketData) query.uniqueResult();
        int t = query.list().size();
        if (t > 0) {
//            ticketData = (TicketData) query.list().get(0);
            ticketData.setId((int) query.list().get(0));
        }
        return t;
//        return (query.uniqueResult() != null);
    }

    @Override
    public List<TicketData> getAllTicketsByEventId(int id) {
        List<TicketData> ticketDataList;
        Query query;
        query = sessionFactory.getCurrentSession().createQuery("SELECT t FROM TicketData t WHERE t.eventId=:eventId")
                .setParameter("eventId", id);
        ticketDataList = query.getResultList();
        return ticketDataList;
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
    //    }
    //        sessionFactory.getCurrentSession().createNamedQuery("INSERT ");
    //        Query query;
//    private void updateHistory(TicketData ticketData){
}
