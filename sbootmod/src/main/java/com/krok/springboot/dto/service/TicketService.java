package com.krok.springboot.dto.service;

import com.krok.data.TicketData;

import java.util.List;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

public interface TicketService {

    int sendScannedData(TicketData ticketData);

    TicketData getTicketById(int id);

    TicketData getTicketByCode(String code);

    List<TicketData> getAllTicketsByEventId(int id);

    boolean deleteTicketById(int id);

}
