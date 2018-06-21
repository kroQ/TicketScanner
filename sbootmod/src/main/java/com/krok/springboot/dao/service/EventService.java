package com.krok.springboot.dao.service;

import com.krok.data.EventData;
import com.krok.error.AppException;

import java.util.List;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

public interface EventService {

    void create(EventData eventData) throws AppException;

    EventData getEventById(int id);

    EventData getEventByNameAndCode(EventData eventData) throws AppException;

    List<EventData> getAllEventsByUserId(int id) throws AppException;

    boolean deleteEventById(int id);

}
