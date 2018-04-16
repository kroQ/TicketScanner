package com.krok.springboot.api;

import com.krok.springboot.data.UserData;
import com.krok.springboot.dto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

@RestController
public class UserController {

    @Autowired
    UserService userService;

    // ******************** USER API ******************* //

    @RequestMapping("/user/{id}")
    public String findUser(@PathVariable("id") int id) {
        try {
            UserData user = userService.getUserById(id);
            return user.toString();
        } catch (NoResultException e) {
            return "No user find";
        }
    }

    @RequestMapping("/user/generate")
    public String newUser() {
        // TODO RequestBody and ResponseBody
        UserData user;
        user = new UserData("N", "S", "P", "E", "L", 1);
        userService.createOrUpdate(user);
        return user.toString();
    }

    @RequestMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        boolean isDeleted = userService.deleteUserById(id);
        return isDeleted ? "Deleted: " + id : "User not exist";
    }


}
