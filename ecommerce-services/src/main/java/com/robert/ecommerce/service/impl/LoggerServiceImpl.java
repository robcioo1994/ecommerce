package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.LoggingDTO;
import com.robert.ecommerce.entity.LoggingEntity;
import com.robert.ecommerce.repository.AccountRepository;
import com.robert.ecommerce.repository.LoggerRepository;
import com.robert.ecommerce.service.LoggerService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService {

    @Autowired
    private LoggerRepository loggerRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MapperFacade mapper;

//    @Autowired
//    public LoggerServiceImpl(LoggerRepository loggerRepository, AccountRepository accountRepositor, MapperFacade mapper) {
//        this.loggerRepository = loggerRepository;
//        this.accountRepository = accountRepository;
//        this.mapper = mapper;
//    }

    @Override
    public void registerNewLog(LoggingDTO newLog) {
        System.out.println(newLog.toString());
        LoggingEntity loggingEntity = new LoggingEntity();
        loggingEntity.setAccount(accountRepository.findByUsername(newLog.getUserName()).get());
        System.out.println(loggingEntity.toString());
        loggingEntity.setProductId(newLog.getProductId());
        System.out.println(loggingEntity.toString());
        loggingEntity.setTime(newLog.getTime());
        System.out.println(loggingEntity.toString());

        loggerRepository.save(loggingEntity);
    }
}
