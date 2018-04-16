package com.krok.springboot.api;

import com.krok.springboot.data.DeviceData;
import com.krok.springboot.dto.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;

/**
 * Created by Mateusz Krok on 2018-04-15
 */

@RestController
public class DeviceController {

    @Autowired
    DeviceService deviceService;

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

    @RequestMapping("/device/generate")
    public String newDevice() {
        // TODO RequestBody and ResponseBody
        DeviceData device = new DeviceData();
        device.setDeviceType("Phone");
        device.setName("Samsung Galaxy S5");
        deviceService.createOrUpdate(device);
        return device.toString();
    }

    @RequestMapping("/device/delete/{id}")
    public String deleteDevice(@PathVariable("id") int id) {
        boolean isDeleted = deviceService.deleteDeviceById(id);
        return isDeleted ? "Deleted: " + id : "Device not exist";
    }


}
