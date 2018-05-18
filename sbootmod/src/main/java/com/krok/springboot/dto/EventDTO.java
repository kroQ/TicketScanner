package com.krok.springboot.dto;

import com.krok.data.EventData;
import com.krok.error.AppException;
import com.krok.error.DAOError;
import com.krok.springboot.dto.service.EventService;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by Mateusz Krok on 2018-04-15
 */

@Component
@Transactional
public class EventDTO implements EventService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void createOrUpdate(EventData eventData) {
        sessionFactory.getCurrentSession().saveOrUpdate(eventData);
    }

    @Override
    public EventData getEventById(int id) {
        return (EventData) sessionFactory.getCurrentSession().createQuery("FROM EventData event WHERE event.id=:id")
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<EventData> getAllEvents() {
        List<EventData> eventList;
        Query query;
        query = sessionFactory.getCurrentSession().createQuery("SELECT e FROM EventData e");
        eventList = query.getResultList();
        return eventList;
    }

    @Override
    public EventData getEventByCode(String code) throws AppException {
        try {
            EventData event = (EventData) sessionFactory.getCurrentSession().createQuery("FROM EventData event WHERE event.code=:code")
                    .setParameter("code", code).getSingleResult();
            return event;
        } catch (NoResultException e) {
            throw new AppException(DAOError.EVENT_NOT_FOUND, code);
        }
    }

    @Override
    public boolean deleteEventById(int id) {
        return sessionFactory.getCurrentSession().createQuery("DELETE EventData WHERE id = :id")
                .setParameter("id", id).executeUpdate() > 0;
    }
}
