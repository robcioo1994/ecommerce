package com.robert.ecommerce.rest;

import com.robert.ecommerce.dto.LoggingDTO;
import com.robert.ecommerce.entity.LaptopRecordEntity;
import com.robert.ecommerce.repository.LoggerRepository;
import com.robert.ecommerce.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class LoggerRestController {

    @Autowired
    private LoggerService loggerService;

    @Autowired
    private LoggerRepository loggerRepository;

    @RequestMapping(method = POST, path = "api/all/log", produces = APPLICATION_JSON_VALUE)
    public void registerNewLog(@RequestBody LoggingDTO log) {
        System.out.println(log);
        loggerService.registerNewLog(log);
    }

    @RequestMapping(method = GET, path = "api/all/log", produces = APPLICATION_JSON_VALUE)
    public void getBlabla() {
        loggerRepository.getRecords().forEach(item -> System.out.println(item.toString()));
    }
}
