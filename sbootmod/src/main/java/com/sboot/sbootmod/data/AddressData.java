package com.sboot.sbootmod.data;

import java.util.Objects;

/**
 * Created by Mateusz Krok on 2018-03-15
 */

public class AddressData {

    private int id;
    private String country;
    private String city;
    private String street;
    private String postCode;
    private String apartmentNumber;

    public AddressData(int id, String country, String city, String street, String postCode, String apartmentNumber) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.postCode = postCode;
        this.apartmentNumber = apartmentNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressData that = (AddressData) o;
        return id == that.id &&
                Objects.equals(country, that.country) &&
                Objects.equals(city, that.city) &&
                Objects.equals(street, that.street) &&
                Objects.equals(postCode, that.postCode) &&
                Objects.equals(apartmentNumber, that.apartmentNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, country, city, street, postCode, apartmentNumber);
    }

    @Override
    public String toString() {
        return "AddressData{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                '}';
    }
}
