package com.krok.json.mapper.service;

import com.krok.data.TicketData;
import com.krok.json.TicketJson;

/**
 * Created by Mateusz Krok on 2018-05-04
 */

public interface TicketMapperService {

    TicketJson toTicketJson(TicketData ticketData);

    TicketData toTicketData(TicketJson json);

}
