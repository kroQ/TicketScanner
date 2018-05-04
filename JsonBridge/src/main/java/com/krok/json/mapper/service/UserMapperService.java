package com.krok.json.mapper.service;

import com.krok.data.UserData;
import com.krok.json.UserJson;

/**
 * Created by Mateusz Krok on 2018-04-16
 */

public interface UserMapperService {

    UserJson toUserJson(UserData user);

    UserData toUserData(UserJson json);

}
