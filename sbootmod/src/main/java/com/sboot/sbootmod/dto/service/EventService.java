package com.sboot.sbootmod.dto.service;

import com.sboot.sbootmod.data.EventData;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

public interface EventService {

    void createOrUpdate(EventData eventData);

    EventData getEventById(int id);

    void deleteEventById(int id);

}
