package com.krok.springboot.api;

import com.krok.springboot.data.TicketData;
import com.krok.springboot.dto.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;
import java.util.Calendar;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

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

    @RequestMapping("/ticket/generate")
    public String newTicket() {
        // TODO RequestBody and ResponseBody
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        TicketData ticket;
        ticket = new TicketData("N", "S", "E", 1, "S", "S", "F", 'S', today.getTime(), 123123123, "33E", "C");
        ticketService.createOrUpdate(ticket);
        return ticket.toString();
    }

    @RequestMapping("/ticket/delete/{id}")
    public String deleteTicket(@PathVariable("id") int id) {
        boolean isDeleted = ticketService.deleteTicketById(id);
        return isDeleted ? "Deleted: " + id : "Ticket not exist";
    }

}
