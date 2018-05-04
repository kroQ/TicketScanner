package com.krok.springboot.dto.service;

import com.krok.data.EventData;

import java.util.List;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

public interface EventService {

    void createOrUpdate(EventData eventData);

    EventData getEventById(int id);

    EventData getEventByCode(String code);

    List<EventData> getAllEvents();

    boolean deleteEventById(int id);

}
