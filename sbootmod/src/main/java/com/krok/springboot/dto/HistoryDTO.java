package com.krok.springboot.dto;

import com.krok.springboot.data.HistoryData;
import com.krok.springboot.dto.service.HistoryService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

@Component
@Transactional
public class HistoryDTO implements HistoryService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void createOrUpdate(HistoryData historyData) {
        sessionFactory.getCurrentSession().saveOrUpdate(historyData);
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
