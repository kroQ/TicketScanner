package com.krok.springboot.dto.service;

import com.krok.springboot.data.UserData;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

public interface UserService {

    void createOrUpdate(UserData userData);

    UserData getUserById(int id);

    boolean deleteUserById(int id);

}
