package com.krok.springboot.dao;

import com.krok.data.DeviceData;
import com.krok.error.AppException;
import com.krok.error.DAOError;
import com.krok.springboot.dao.service.DeviceService;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mateusz Krok on 2018-04-15
 */

@Component
@Transactional
public class DeviceDAO implements DeviceService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void createOrUpdate(DeviceData deviceData) throws AppException {
        DeviceData dbData;
        dbData = isExisting(deviceData);
        if (dbData == null) {
            sessionFactory.getCurrentSession().save(deviceData);
        } else {
            deviceData.setId(dbData.getId());
            throw new AppException(DAOError.DEVICE_ALREADY_REGISTERED, deviceData.getAndroidId());
        }
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

    private DeviceData isExisting(DeviceData deviceData) {
        Query query;
        query = sessionFactory.getCurrentSession()
                .createQuery("FROM DeviceData device WHERE device.androidId=:androidId")
                .setParameter("androidId", deviceData.getAndroidId());
        return (DeviceData) query.getResultList().get(0);
    }
}
