package com.krok.springboot.api;

import com.krok.data.DeviceData;
import com.krok.error.AppException;
import com.krok.json.DeviceJson;
import com.krok.json.mapper.DeviceMapper;
import com.krok.springboot.dto.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.logging.Logger;

/**
 * Created by Mateusz Krok on 2018-04-15
 */

@RestController
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    private static Logger logger = Logger.getLogger(
            Thread.currentThread().getStackTrace()[0].getClassName());

    // ******************** DEVICE API ******************* //

    @RequestMapping("/device/{id}")
    public String findDevice(@PathVariable("id") int id) {
        try {
            DeviceData device = deviceService.getDeviceById(id);
            return device.toString();
        } catch (NoResultException e) {
            return "No device find";
        }
    }

    @RequestMapping(value = "/device", method = RequestMethod.POST)
    public ResponseEntity<DeviceJson> newDevice(@RequestBody DeviceJson deviceJson) {
        DeviceData device;
        DeviceMapper deviceMapper = new DeviceMapper();

        device = deviceMapper.toDeviceData(deviceJson);
        try {
            deviceService.createOrUpdate(device);
        } catch (AppException e) {
            logger.info("Device ID: " + device.getId());
            return new ResponseEntity<>(deviceMapper.toDeviceJson(device), HttpStatus.IM_USED);
        }

        logger.info("New Device Registered: " + device.getId());
        deviceJson.setId(device.getId());
        return new ResponseEntity<>(deviceJson, HttpStatus.OK);
    }

    @RequestMapping("/device/delete/{id}")
    public String deleteDevice(@PathVariable("id") int id) {
        boolean isDeleted = deviceService.deleteDeviceById(id);
        return isDeleted ? "Deleted: " + id : "Device not exist";
    }


}
