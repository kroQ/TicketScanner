package com.krok.springboot.api;

import com.krok.data.UserData;
import com.krok.error.AppException;
import com.krok.error.DAOError;
import com.krok.json.UserJson;
import com.krok.json.mapper.UserMapper;
import com.krok.json.mapper.service.UserMapperService;
import com.krok.springboot.dto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;
import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapperService userMapperService;

    private static Logger logger = Logger.getLogger(
            Thread.currentThread().getStackTrace()[0].getClassName());

    // ******************** USER API ******************* //

    @RequestMapping(value = "/user/{id}", method = GET)
    public String findUser(@PathVariable("id") int id) {
        try {
            UserData user = userService.getUserById(id);
            UserJson json = userMapperService.toUserJson(user);
            return user.toString() + "\n\n\n" + json;
        } catch (NoResultException e) {
            return "No user find";
        }
    }

    @RequestMapping(value = "/user/2/{id}", method = GET)
    public UserData findUser2(@PathVariable("id") int id) {
        try {
            UserData user = userService.getUserById(id);
            return user;
        } catch (NoResultException e) {
            return null;
        }
    }

    @RequestMapping(value = "/user/{id}", method = DELETE)
    public String deleteUserById(@PathVariable("id") int id) {
        boolean isDeleted = userService.deleteUserById(id);
        return isDeleted ? "Deleted: " + id : "User not exist";
    }

    @RequestMapping(value = "/user/register", method = POST)
    public ResponseEntity<UserJson> newUser(@RequestBody UserJson userJson) {
        logger.info("/user/register: " + userJson.getLogin());
        logger.info("/user/login_devIDg: " + userJson.getDeviceId());
        UserMapper userMapper = new UserMapper();
        UserData userData;
        try {
            userData = userMapper.toUserData(userJson);
            userService.createOrUpdate(userData);
        } catch (AppException e) {
            logger.info(e.getCodeMessage());
            return new ResponseEntity<>(userJson, HttpStatus.IM_USED);
        }
        return new ResponseEntity<>(userMapper.toUserJson(userData), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/login", method = POST)
    public ResponseEntity<UserJson> login(@RequestBody UserJson user) {
        logger.info("/user/login: " + user.getLogin());
        UserMapper userMapper = new UserMapper();
        UserData userData = userMapper.toUserData(user);
        try {
            userData = userService.getUserByLogin(userData);
            return new ResponseEntity<>(userMapper.toUserJson(userData), HttpStatus.OK);
        } catch (AppException e) {
            logger.info(e.getCodeMessage());
            if (e.getErrorCode().equals(DAOError.LOGIN_NOT_FOUND)) {
                return new ResponseEntity<>(new UserJson(), HttpStatus.NO_CONTENT);
            } else if (e.getErrorCode().equals(DAOError.WRONG_PASSWORD)) {
                return new ResponseEntity<>(new UserJson(), HttpStatus.IM_USED);
            }
            logger.info(e.getCodeMessage());
            return new ResponseEntity<>(new UserJson(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        boolean isDeleted = userService.deleteUserById(id);
        return isDeleted ? "Deleted: " + id : "User not exist";
    }


}
