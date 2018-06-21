package com.krok.springboot.dao;

import com.krok.data.HistoryData;
import com.krok.springboot.dao.service.HistoryService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

@Component
@Transactional
public class HistoryDAO implements HistoryService {

    private static Logger logger = Logger.getLogger(
            Thread.currentThread().getStackTrace()[0].getClassName());

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void createOrUpdate(HistoryData historyData) {
        boolean isHere;
        List response;

        logger.info("TICKET ID: " + historyData.getTicketId());

        response = sessionFactory.getCurrentSession().createQuery("SELECT h.isInside from HistoryData h " +
                "where h.ticketId = :ticketId order by h.id desc ").setParameter("ticketId", historyData.getTicketId()).list();

        if (response.size() > 0) {
            isHere = (boolean) response.get(0);
        } else {
            isHere = false;
        }
        historyData.setInside(!isHere);
        sessionFactory.getCurrentSession().save(historyData);
    }

    @Override
    public List<HistoryData> getHistoryListByUserId(int id) {
        List<HistoryData> historyList;
        historyList = sessionFactory.getCurrentSession().createQuery("FROM HistoryData history WHERE history.userId=:id", HistoryData.class)
                .setParameter("id", id).getResultList();
        return historyList;
    }

    @Override
    public List<HistoryData> getHistoryListByTicketId(int id) {
        List<HistoryData> historyList;
        historyList = sessionFactory.getCurrentSession().createQuery("FROM HistoryData history WHERE history.ticketId=:id", HistoryData.class)
                .setParameter("id", id).getResultList();
        return historyList;
    }

    @Override
    public List<HistoryData> getHistoryListByEventId(int id) {
        List<HistoryData> historyList;
        historyList = sessionFactory.getCurrentSession().createQuery("FROM HistoryData history WHERE history.eventId=:id", HistoryData.class)
                .setParameter("id", id).getResultList();
        return historyList;
    }
}
