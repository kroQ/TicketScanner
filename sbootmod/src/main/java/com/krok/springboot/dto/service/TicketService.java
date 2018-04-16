package com.krok.springboot.dto.service;

import com.krok.springboot.data.TicketData;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

public interface TicketService {

    void createOrUpdate(TicketData ticketData);

    TicketData getTicketById(int id);

    TicketData getTicketByCode(String code);

    boolean deleteTicketById(int id);

}
