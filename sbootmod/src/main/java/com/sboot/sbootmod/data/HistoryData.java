package com.sboot.sbootmod.data;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by Mateusz Krok on 2018-04-12
 */

@Entity
@Table(name = "HISTORY")
public class HistoryData {

    @Id
    @Column(name = "HIS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "HIS_TICKET_ID")
    private int ticketId;

    @Column(name = "HIS_USER_ID")
    private int userId;

    @Column(name = "HIS_IS_INSIDE")
    private boolean isInside;

    @Column(name = "HIS_EVENT_ID")
    private int eventId;

    @Column(name = "HIS_DATE")
    private Date date;

    @Column(name = "HIS_TIME")
    private LocalTime time;

    public HistoryData() {
    }

    public HistoryData(int ticketId, int userId, boolean isInside, int eventId, Date date, LocalTime time) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.isInside = isInside;
        this.eventId = eventId;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isInside() {
        return isInside;
    }

    public void setInside(boolean inside) {
        isInside = inside;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "HistoryData{" +
                "id=" + id +
                ", ticketId=" + ticketId +
                ", userId=" + userId +
                ", isInside=" + isInside +
                ", eventId=" + eventId +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
