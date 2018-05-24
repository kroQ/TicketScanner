package com.krok.json.mapper;

import com.krok.data.TicketData;
import com.krok.json.TicketJson;
import com.krok.json.mapper.service.TicketMapperService;

/**
 * Created by Mateusz Krok on 2018-05-04
 */

public class TicketMapper implements TicketMapperService {

    public TicketJson toTicketJson(TicketData ticketData) {
        TicketJson json = new TicketJson();
        json.setId(ticketData.getId());
        json.setBirthDate(ticketData.getBirthDate());
        json.setCity(ticketData.getCity());
        json.setCode(ticketData.getCode());
        json.setEmail(ticketData.getEmail());
        json.setFlatNr(ticketData.getFlatNr());
        json.setName(ticketData.getName());
        json.setPhone(ticketData.getPhone());
        json.setSeatNumber(ticketData.getSeatNumber());
        json.setSex(ticketData.getSex());
        json.setStreet(ticketData.getStreet());
        json.setSurname(ticketData.getSurname());
        json.setEventId(ticketData.getEventId());
        return json;
    }

    public TicketData toTicketData(TicketJson json) {
        TicketData ticketData = new TicketData();
        ticketData.setId(json.getId());
        ticketData.setBirthDate(json.getBirthDate());
        ticketData.setCity(json.getCity());
        ticketData.setEmail(json.getEmail());
        ticketData.setCode(json.getCode());
        ticketData.setFlatNr(json.getFlatNr());
        ticketData.setName(json.getName());
        ticketData.setPhone(json.getPhone());
        ticketData.setSeatNumber(json.getSeatNumber());
        ticketData.setSex(json.getSex());
        ticketData.setStreet(json.getStreet());
        ticketData.setSurname(json.getSurname());
        ticketData.setEventId(json.getEventId());
        return ticketData;
    }
}
