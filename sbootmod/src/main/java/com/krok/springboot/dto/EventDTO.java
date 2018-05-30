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
    public void create(EventData eventData) throws AppException {
        if (isEventUnique(eventData)) {
            sessionFactory.getCurrentSession().save(eventData);
        } else {
            throw new AppException(DAOError.EVENT_IS_NOT_UNIQUE, eventData.getName());
        }
    }

    private boolean isEventUnique(EventData eventData) {
        Query query;
        query = sessionFactory.getCurrentSession().createQuery("FROM EventData event WHERE event.name=:name")
                .setParameter("name", eventData.getName());
        return query.getResultList().size() == 0;
    }

    @Override
    public EventData getEventById(int id) {
        return (EventData) sessionFactory.getCurrentSession().createQuery("FROM EventData event WHERE event.id=:id")
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<EventData> getAllEventsByUserId(int id) {
        List<EventData> eventList;
        Query query;
        query = sessionFactory.getCurrentSession().createQuery("SELECT e FROM EventData e WHERE e.ownerId=:id")
                .setParameter("id", id);
        eventList = query.getResultList();
        return eventList;
    }

    @Override
    public EventData getEventByNameAndCode(EventData eventData) throws AppException {
        try {
            EventData event = (EventData) sessionFactory.getCurrentSession().createQuery("FROM EventData event WHERE event.name=:name")
                    .setParameter("name", eventData.getName()).getSingleResult();
            if (event.getCode().equals(eventData.getCode())) {
                return event;
            }
            throw new AppException(DAOError.WRONG_CODE, eventData.getName());
        } catch (NoResultException e) {
            throw new AppException(DAOError.EVENT_NOT_FOUND, eventData.getName());
        }
    }

    @Override
    public boolean deleteEventById(int id) {
        return sessionFactory.getCurrentSession().createQuery("DELETE EventData WHERE id = :id")
                .setParameter("id", id).executeUpdate() > 0;
    }
}
