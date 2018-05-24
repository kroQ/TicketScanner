package com.krok.springboot.dto;

import com.krok.data.TicketData;
import com.krok.error.AppException;
import com.krok.error.DAOError;
import com.krok.springboot.dto.service.TicketService;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public void sendScannedData(TicketData ticketData) throws AppException {
        if (checkIfExist(ticketData)) {
            throw new AppException(DAOError.TICKET_ALREADY_EXIST, ticketData.getCode());
        }
        sessionFactory.getCurrentSession().save(ticketData);


    }

    private boolean checkIfExist(TicketData ticketData) {
        Query query = sessionFactory.getCurrentSession().createQuery("select 1 from TicketData t where t.code = :code");
        query.setParameter("code", ticketData.getCode());
        return (query.uniqueResult() != null);
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
