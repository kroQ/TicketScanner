package com.krok.json.mapper;

import com.krok.data.DeviceData;
import com.krok.json.DeviceJson;
import com.krok.json.mapper.service.DeviceMapperService;

/**
 * Created by Mateusz Krok on 2018-05-04
 */

public class DeviceMapper implements DeviceMapperService {

    @Override
    public DeviceJson toDeviceJson(DeviceData deviceData) {
        DeviceJson json = new DeviceJson();
        json.setId(deviceData.getId());
        json.setName(deviceData.getName());
        json.setDeviceType(deviceData.getDeviceType());
        json.setAndroidId(deviceData.getAndroidId());
        return json;
    }

    @Override
    public DeviceData toDeviceData(DeviceJson json) {
        DeviceData deviceData = new DeviceData();
        deviceData.setId(json.getId());
        deviceData.setName(json.getName());
        deviceData.setDeviceType(json.getDeviceType());
        deviceData.setAndroidId(json.getAndroidId());
        return deviceData;
    }
}
