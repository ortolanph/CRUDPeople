package org.crudpeople.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.crudpeople.external.simple.ArrayResult;
import org.crudpeople.external.simple.SimpleResult;
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
    SimpleResult test() {
        LOGGER.log(Level.INFO, "Callling /test service");
        
        SimpleResult result = new SimpleResult();
        result.setResult("testing");
        
        return result;
    }

    @RequestMapping(value = "/echo/{message}", method = RequestMethod.GET)
    public @ResponseBody
    SimpleResult echo(@PathVariable String message) {
        LOGGER.log(Level.INFO, "Callling /echo service with {0} parameter", message);
        
        SimpleResult result = new SimpleResult();
        result.setResult(message);
        
        return result;
    }

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public @ResponseBody
    ArrayResult api() {
        LOGGER.log(Level.INFO, "Callling /api service");
        
        String[] urls = {
                "/crudpeople/testservice/test",
                "/crudpeople/testservice/echo/{message}",
                "/crudpeople/testservice/api"
        };
        
        ArrayResult result = new ArrayResult();
        result.setResult(urls);

        return result;
    }
}