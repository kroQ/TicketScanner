package com.sboot.sbootmod.data;

import java.util.Objects;

/**
 * Created by Mateusz Krok on 2018-03-15
 */


public class PersonData {

    private int id;
    private String name;
    private String surname;
    private String nickname;
    private String password;

    public PersonData() {
    }

    public PersonData(int id, String name, String surname, String nickname, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.password = password;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonData personData = (PersonData) o;
        return id == personData.id &&
                Objects.equals(name, personData.name) &&
                Objects.equals(surname, personData.surname) &&
                Objects.equals(nickname, personData.nickname) &&
                Objects.equals(password, personData.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname, nickname, password);
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
