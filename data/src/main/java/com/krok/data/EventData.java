package com.krok.data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mateusz Krok on 2018-03-15
 */

@Entity
@Table(name = "EVENTS")
public class EventData {

    @Id
    @Column(name = "EVE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //TODO unique
    @Column(name = "EVE_CODE")
    private String code;

    @Column(name = "EVE_START_DATE")
    private Date startEventDate;

    @Column(name = "EVE_END_DATE")
    private Date endEventDate;

    @Column(name = "EVE_OWNER_ID")
    private int ownerId;

    @Column(name = "EVE_TICKET_POOL_ID")
    private int ticketsPool;

    public EventData(String code, Date startEventDate, Date endEventDate, int ownerId, int ticketsPool) {
        this.code = code;
        this.startEventDate = startEventDate;
        this.endEventDate = endEventDate;
        this.ownerId = ownerId;
        this.ticketsPool = ticketsPool;
    }

    public EventData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "EventData{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", startEventDate=" + startEventDate +
                ", endEventDate=" + endEventDate +
                ", ownerId=" + ownerId +
                ", ticketsPool=" + ticketsPool +
                '}';
    }
}
