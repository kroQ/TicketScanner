package com.sboot.sbootmod.dto.service;

import com.sboot.sbootmod.data.UserData;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

public interface UserService {

    void createOrUpdate(UserData userData);

    UserData getUserById(int id);

    boolean deleteUserById(int id);

}
