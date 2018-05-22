package com.krok.springboot.dto.service;

import com.krok.data.EventData;
import com.krok.error.AppException;

import java.util.List;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

public interface EventService {

    void create(EventData eventData) throws AppException;

    EventData getEventById(int id);

    EventData getEventByName(String name) throws AppException;

    List<EventData> getAllEvents();

    boolean deleteEventById(int id);

}
