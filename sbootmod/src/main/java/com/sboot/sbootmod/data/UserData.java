package com.sboot.sbootmod.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mateusz Krok on 2018-04-09
 */

@Entity
@Table(name = "USERS")
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="USR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="USR_NAME")
    private String name;
    @Column(name="USR_SURNAME")
    private String surname;
    @Column(name="USR_PASSWORD")
    private String password;
    @Column(name="USR_EMAIL")
    private String email;
    @Column(name="USR_LOGIN")
    private String login;
    @Column(name="USR_DEVICE_ID")
    private Date birthDate;

    public UserData(){
    }

    public UserData(String name, String surname, String password, String email, String login, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.login = login;
        this.birthDate = birthDate;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}