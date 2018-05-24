package com.krok.springboot.api;

import com.krok.data.HistoryData;
import com.krok.data.TicketData;
import com.krok.error.AppException;
import com.krok.error.DAOError;
import com.krok.json.TicketJson;
import com.krok.json.mapper.TicketMapper;
import com.krok.springboot.dto.service.HistoryService;
import com.krok.springboot.dto.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.logging.Logger;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    HistoryService historyService;

    private static Logger logger = Logger.getLogger(
            Thread.currentThread().getStackTrace()[0].getClassName());

    // ******************** TICKET API ******************* //

    @RequestMapping("/ticket/{id}")
    public String findTicketById(@PathVariable("id") int id) {
        try {
            TicketData ticket = ticketService.getTicketById(id);
            return ticket.toString();
        } catch (NoResultException e) {
            return "No ticket find";
        }
    }

    @RequestMapping("/ticket/code/{code}")
    public String findTicketByCode(@PathVariable("code") String code) {
        try {
            TicketData ticket = ticketService.getTicketByCode(code);
            return ticket.toString();
        } catch (NoResultException e) {
            return "No ticket find";
        }
    }

    @RequestMapping(value = "/ticket/{userId}/{eventId}", method = RequestMethod.POST)
    public ResponseEntity newTicket(@PathVariable("userId") int userId, @PathVariable("eventId") int eventId, @RequestBody TicketJson ticketJson) {
        logger.info("/ticket/userId/eventId: " + userId + " " + eventId);
        TicketMapper mapper = new TicketMapper();
        TicketData ticketData = mapper.toTicketData(ticketJson);

        //TODO dostac ticketID i go przypisac do histori

        HistoryData historyData = new HistoryData();
        historyData.setEventId(ticketJson.getEventId());
        historyData.setUserId(ticketJson.getUserId());
        historyData.setDate(Calendar.getInstance().getTime());
        historyData.setTime(LocalTime.now());

        historyService.createOrUpdate(historyData);

        try {
            ticketService.sendScannedData(ticketData);
        } catch (AppException e) {
            if (e.getErrorCode() == DAOError.TICKET_ALREADY_EXIST && historyData.isInside()) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(HttpStatus.IM_USED);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping("/ticket/delete/{id}")
    public String deleteTicket(@PathVariable("id") int id) {
        boolean isDeleted = ticketService.deleteTicketById(id);
        return isDeleted ? "Deleted: " + id : "Ticket not exist";
    }

}
