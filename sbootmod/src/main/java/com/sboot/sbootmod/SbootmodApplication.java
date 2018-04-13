package com.sboot.sbootmod;

import com.sboot.sbootmod.data.ZZZ;
import com.sboot.sbootmod.dto.service.DBQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@RestController
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SbootmodApplication {

    @Autowired
    DBQuery dbQuery;

    private static final Logger LOGGER = Logger.getLogger("InfoLogging");

    public static void main(String[] args) {
        SpringApplication.run(SbootmodApplication.class, args);
    }

    @RequestMapping("/mod")
    public String mod() {
        LOGGER.info("URL: /mod");
        return "tak, Witamy";
    }


    @RequestMapping("/mod/{name}")
    public String mod2(@PathVariable String name) {
        return "USER: " + dbQuery.getName(name);
    }

    @RequestMapping("create/{name}/{surname}/{nickname}/{password}/{email}")
    public String createUser(@PathVariable String name, @PathVariable String surname, @PathVariable String nickname, @PathVariable String password, @PathVariable String email) {
        dbQuery.ge(new ZZZ(name, surname, nickname, password, email));
        return "Created: " + dbQuery.getName(name);
    }


}
