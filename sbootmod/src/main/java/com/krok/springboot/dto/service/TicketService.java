package com.krok.springboot.dto.service;

import com.krok.data.TicketData;
import com.krok.error.AppException;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

public interface TicketService {

    void sendScannedData(TicketData ticketData) throws AppException;

    TicketData getTicketById(int id);

    TicketData getTicketByCode(String code);

    boolean deleteTicketById(int id);

}
