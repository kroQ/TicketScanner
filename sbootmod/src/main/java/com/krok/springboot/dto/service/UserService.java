package com.krok.springboot.dto.service;

import com.krok.data.UserData;
import com.krok.error.AppException;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

public interface UserService {

    void createOrUpdate(UserData userData) throws AppException;

    UserData getUserById(int id);

    UserData getUserByLogin(UserData userData) throws AppException;

    boolean deleteUserById(int id);

}
