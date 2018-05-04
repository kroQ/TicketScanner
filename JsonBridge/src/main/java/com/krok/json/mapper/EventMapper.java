package com.krok.json.mapper;

import com.krok.data.EventData;
import com.krok.json.EventJson;
import com.krok.json.mapper.service.EventMapperService;

/**
 * Created by Mateusz Krok on 2018-05-04
 */

public class EventMapper implements EventMapperService {

    public EventJson toEventJson(EventData event) {
        EventJson json = new EventJson();
        json.setId(event.getId());
        json.setCode(event.getCode());
        json.setEndEventDate(event.getEndEventDate());
        json.setOwnerId(event.getOwnerId());
        json.setStartEventDate(event.getStartEventDate());
        json.setTicketsPool(event.getTicketsPool());
        return json;
    }

    public EventData toEventData(EventJson json) {
        EventData event = new EventData();
        event.setId(json.getId());
        event.setCode(json.getCode());
        event.setEndEventDate(json.getEndEventDate());
        event.setOwnerId(json.getOwnerId());
        event.setStartEventDate(json.getStartEventDate());
        event.setTicketsPool(json.getTicketsPool());
        return event;
    }
}
