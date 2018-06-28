package com.krok.springboot.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mateusz Krok on 2018-06-22
 */

@Controller
public class WebToController {

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String settings() {
        return "settings";
    }

    @RequestMapping(value = "/dynamic-routing", method = RequestMethod.GET)
    public String dynamicRouting() {
        return "dynamic-routing";
    }

}
