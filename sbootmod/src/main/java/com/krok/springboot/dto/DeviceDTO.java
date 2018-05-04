package com.krok.springboot.dto;

import com.krok.data.DeviceData;
import com.krok.springboot.dto.service.DeviceService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mateusz Krok on 2018-04-15
 */

@Component
@Transactional
public class DeviceDTO implements DeviceService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void createOrUpdate(DeviceData deviceData) {
        sessionFactory.getCurrentSession().saveOrUpdate(deviceData);
    }

    @Override
    public DeviceData getDeviceById(int id) {
        return (DeviceData) sessionFactory.getCurrentSession().createQuery("FROM DeviceData device WHERE device.id=:id")
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public boolean deleteDeviceById(int id) {
        return sessionFactory.getCurrentSession().createQuery("DELETE DeviceData WHERE id = :id")
                .setParameter("id", id).executeUpdate() > 0;
    }
}
