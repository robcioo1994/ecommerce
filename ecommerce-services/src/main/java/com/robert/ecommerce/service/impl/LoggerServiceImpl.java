package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.LoggingDTO;
import com.robert.ecommerce.repository.AccountRepository;
import com.robert.ecommerce.repository.LoggerRepository;
import com.robert.ecommerce.service.LoggerService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoggerServiceImpl implements LoggerService {

    final private LoggerRepository loggerRepository;
    final private AccountRepository accountRepository;
    final private MapperFacade mapper;

    @Autowired
    public LoggerServiceImpl(LoggerRepository loggerRepository, AccountRepository accountRepository, MapperFacade mapper) {
        this.loggerRepository = loggerRepository;
        this.accountRepository = accountRepository;
        this.mapper = mapper;
    }

    @Override
    public void registerNewLog(LoggingDTO newLog) {

    }

    @Override
    public List<LoggingDTO> findAllLogSByEmail(String email) {
        return null;
    }
}
