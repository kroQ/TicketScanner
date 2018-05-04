package com.krok.data;

import javax.persistence.*;

/**
 * Created by Mateusz Krok on 2018-04-09
 */

@Entity
@Table(name = "USERS")
public class UserData {

    @Id
    @Column(name = "USR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USR_NAME")
    private String name;

    @Column(name = "USR_SURNAME")
    private String surname;

    @Column(name = "USR_LOGIN")
    private String login;

    @Column(name = "USR_EMAIL")
    private String email;

    @Column(name = "USR_PASSWORD")
    private String password;

    @Column(name = "USR_DEVICE_ID")
    private int deviceId;

    public UserData() {
    }

    public UserData(String name, String surname, String password, String email, String login, int deviceId) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.login = login;
        this.deviceId = deviceId;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "com.krok.data.UserData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", birthDate=" + deviceId +
                '}';
    }
}
