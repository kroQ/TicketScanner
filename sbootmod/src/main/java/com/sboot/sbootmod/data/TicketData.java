package com.sboot.sbootmod.data;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Mateusz Krok on 2018-03-15
 */

public class TicketData {

    private int id;
    private String title;
    private Date generateDate;
    private Date startEventDate;
    private int clientId;
    private int eanCode;
    private String seatNumber;

    public TicketData(int id, String title, Date generateDate, Date startEventDate, int clientId, int eanCode, String seatNumber) {
        this.id = id;
        this.title = title;
        this.generateDate = generateDate;
        this.startEventDate = startEventDate;
        this.clientId = clientId;
        this.eanCode = eanCode;
        this.seatNumber = seatNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getGenerateDate() {
        return generateDate;
    }

    public void setGenerateDate(Date generateDate) {
        this.generateDate = generateDate;
    }

    public Date getStartEventDate() {
        return startEventDate;
    }

    public void setStartEventDate(Date startEventDate) {
        this.startEventDate = startEventDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getEanCode() {
        return eanCode;
    }

    public void setEanCode(int eanCode) {
        this.eanCode = eanCode;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketData that = (TicketData) o;
        return id == that.id &&
                clientId == that.clientId &&
                eanCode == that.eanCode &&
                Objects.equals(title, that.title) &&
                Objects.equals(generateDate, that.generateDate) &&
                Objects.equals(startEventDate, that.startEventDate) &&
                Objects.equals(seatNumber, that.seatNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, generateDate, startEventDate, clientId, eanCode, seatNumber);
    }

    @Override
    public String toString() {
        return "TicketData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", generateDate=" + generateDate +
                ", startEventDate=" + startEventDate +
                ", clientId=" + clientId +
                ", eanCode=" + eanCode +
                ", seatNumber='" + seatNumber + '\'' +
                '}';
    }
}
