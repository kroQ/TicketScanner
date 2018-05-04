package com.krok.json.mapper.service;

import com.krok.data.DeviceData;
import com.krok.json.DeviceJson;

/**
 * Created by Mateusz Krok on 2018-05-04
 */

public interface DeviceMapperService {

    DeviceJson toDeviceJson(DeviceData deviceData);

    DeviceData toDeviceData(DeviceJson json);

}
