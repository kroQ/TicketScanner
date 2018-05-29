package com.krok.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mateusz Krok on 2018-05-04
 */

public class EventJson {

    private int id;
    private String code;
    private String name;
    private Date startEventDate;
    private Date endEventDate;
    private int ownerId;
    private int ticketsPool;
    private List<TicketJson> allTickets = new ArrayList<>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getStartEventDate() {
        return startEventDate;
    }

    public void setStartEventDate(Date startEventDate) {
        this.startEventDate = startEventDate;
    }

    public Date getEndEventDate() {
        return endEventDate;
    }

    public void setEndEventDate(Date endEventDate) {
        this.endEventDate = endEventDate;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getTicketsPool() {
        return ticketsPool;
    }

    public void setTicketsPool(int ticketsPool) {
        this.ticketsPool = ticketsPool;
    }

    public List<TicketJson> getAllTickets() {
        return allTickets;
    }

    public void setAllTickets(List<TicketJson> allTickets) {
        this.allTickets = allTickets;
    }
}
