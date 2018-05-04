package com.krok.data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mateusz Krok on 2018-03-15
 */

@Entity
@Table(name = "TICKETS")
public class TicketData {

    // TODO private inrefrace to sex field

    public TicketData(String name, String surname, String email, int eventId, String city, String street, String flatNr, char sex, Date birthDate, int phone, String seatNumber, String code) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.eventId = eventId;
        this.city = city;
        this.street = street;
        this.flatNr = flatNr;
        this.sex = sex;
        this.birthDate = birthDate;
        this.phone = phone;
        this.seatNumber = seatNumber;
        this.code = code;
    }

    public TicketData() {
    }

    @Id
    @Column(name = "TIC_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TIC_NAME")
    private String name;

    @Column(name = "TIC_SURNAME")
    private String surname;

    @Column(name = "TIC_EMAIL")
    private String email;

    @Column(name = "TIC_EVENT_ID")
    private int eventId;

    @Column(name = "TIC_CITY")
    private String city;

    @Column(name = "TIC_STREET")
    private String street;

    @Column(name = "TIC_FLAT_NR")
    private String flatNr;

    @Column(name = "TIC_SEX")
    private char sex;

    @Column(name = "TIC_BIRTH_DATE")
    private Date birthDate;

    @Column(name = "TIC_PHONE")
    private int phone;

    @Column(name = "TIC_SEAT_NR")
    private String seatNumber;

    @Column(name = "TIC_CODE")
    private String code;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFlatNr() {
        return flatNr;
    }

    public void setFlatNr(String flatNr) {
        this.flatNr = flatNr;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TicketData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", eventId=" + eventId +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", flatNr='" + flatNr + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", phone=" + phone +
                ", seatNumber='" + seatNumber + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
