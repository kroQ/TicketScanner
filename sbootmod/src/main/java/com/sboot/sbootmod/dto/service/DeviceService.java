package com.sboot.sbootmod.dto.service;

import com.sboot.sbootmod.data.DeviceData;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

public interface DeviceService {

    void createOrUpdate(DeviceData deviceData);

    DeviceData getDeviceById(int id);

    boolean deleteDeviceById(int id);

}
