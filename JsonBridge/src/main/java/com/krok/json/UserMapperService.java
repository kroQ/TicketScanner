package com.krok.json;

import com.krok.springboot.data.UserData;

/**
 * Created by Mateusz Krok on 2018-04-16
 */

public interface UserMapperService {

    UserJson toUserJson(UserData user);

    UserData toUserData(UserJson json);

}
