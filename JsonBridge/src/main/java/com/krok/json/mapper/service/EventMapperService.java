package com.krok.json.mapper.service;

import com.krok.data.EventData;
import com.krok.json.EventJson;

/**
 * Created by Mateusz Krok on 2018-05-04
 */

public interface EventMapperService {

    EventJson toEventJson(EventData event);

    EventData toEventData(EventJson json);
}
