package com.robert.ecommerce.rest;

import com.robert.ecommerce.dto.LoggingDTO;
import com.robert.ecommerce.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class LoggerRestController {

    @Autowired
    private LoggerService loggerService;

    @RequestMapping(method = POST, path = "api/all/log", produces = APPLICATION_JSON_VALUE)
    public void registerNewLog(@RequestBody LoggingDTO log) {
        System.out.println(log);
        loggerService.registerNewLog(log);
    }
}
