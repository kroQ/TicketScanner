package com.krok.springboot.dto.service;

import com.krok.springboot.data.DeviceData;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

public interface DeviceService {

    void createOrUpdate(DeviceData deviceData);

    DeviceData getDeviceById(int id);

    boolean deleteDeviceById(int id);

}
