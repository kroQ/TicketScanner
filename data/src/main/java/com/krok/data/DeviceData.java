package com.krok.data;

import javax.persistence.*;

/**
 * Created by Mateusz Krok on 2018-04-12
 */

@Entity
@Table(name = "DEVICES")
public class DeviceData {

    @Id
    @Column(name = "DEV_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DEV_TYPE")
    private String deviceType;

    @Column(name = "DEV_NAME")
    private String name;

    @Column(name = "DEV_ANDROID_ID")
    private Long androidId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAndroidId() {
        return androidId;
    }

    public void setAndroidId(Long androidId) {
        this.androidId = androidId;
    }

    @Override
    public String toString() {
        return "DeviceData{" +
                "id=" + id +
                ", deviceType='" + deviceType + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
