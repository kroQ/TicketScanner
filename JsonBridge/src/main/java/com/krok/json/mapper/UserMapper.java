package com.krok.json.mapper;

import com.krok.data.UserData;
import com.krok.json.UserJson;
import com.krok.json.mapper.service.UserMapperService;
import org.springframework.stereotype.Component;

/**
 * Created by Mateusz Krok on 2018-04-16
 */

@Component
public class UserMapper implements UserMapperService {

    public UserJson toUserJson(UserData user) {
        UserJson json = new UserJson();
        json.setId(user.getId());
        json.setDeviceId(user.getDeviceId());
        json.setEmail(user.getEmail());
        json.setLogin(user.getLogin());
        json.setName(user.getName());
        json.setPassword(user.getPassword());
        json.setSurname(user.getSurname());
        return json;
    }

    public UserData toUserData(UserJson json) {
        UserData user = new UserData();
        user.setId(json.getId());
        user.setDeviceId(json.getDeviceId());
        user.setEmail(json.getEmail());
        user.setLogin(json.getLogin());
        user.setName(json.getName());
        user.setPassword(json.getPassword());
        user.setSurname(json.getSurname());
        return user;
    }


}
