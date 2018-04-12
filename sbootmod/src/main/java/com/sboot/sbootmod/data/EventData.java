package com.sboot.sbootmod.data;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by Mateusz Krok on 2018-03-15
 */

public class EventData {

    private int id;
    private String name;
    private int ticketsPool;

    @Column(name="name")
    private Date startEventDate;

    @Column(name="name")
    private Date endEventDate;

    public EventData(int id, String name, int ticketsPool) {
        this.id = id;
        this.name = name;
        this.ticketsPool = ticketsPool;
    }

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

    public int getTicketsPool() {
        return ticketsPool;
    }

    public void setTicketsPool(int ticketsPool) {
        this.ticketsPool = ticketsPool;
    }
}
