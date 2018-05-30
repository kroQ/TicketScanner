package com.krok.springboot.dto.service;

import com.krok.data.DeviceData;
import com.krok.error.AppException;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

public interface DeviceService {

    void createOrUpdate(DeviceData deviceData) throws AppException;

    DeviceData getDeviceById(int id);

    boolean deleteDeviceById(int id);

}
