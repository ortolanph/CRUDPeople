package org.crudpeople.controller;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/crudpeople/testservice/*",
        produces = {"application/json;charset=UTF-8"})
public class TestController {

    private static final Logger LOGGER = Logger.getLogger(TestController.class.getName());

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody
    String test() {
        LOGGER.log(Level.INFO, "Callling /test service");
        return "testing";
    }

    @RequestMapping(value = "/echo/{message}", method = RequestMethod.GET)
    public @ResponseBody
    String echo(@PathVariable String message) {
        LOGGER.log(Level.INFO, "Callling /echo service with {0} parameter", message);
        return message;
    }

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public @ResponseBody
    List<String> api() {
        LOGGER.log(Level.INFO, "Callling /api service");
        List<String> urls = Lists.newArrayList(
                "/crudpeople/testservice/test",
                "/crudpeople/testservice/echo/{message}",
                "/crudpeople/testservice/api"
        );

        return urls;
    }
}
