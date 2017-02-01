package com.robert.ecommerce.service;

import com.robert.ecommerce.dto.LoggingDTO;

import java.util.List;

public interface LoggerService {

    void registerNewLog(LoggingDTO newLog);

    List<LoggingDTO> findAllLogSByEmail(String email);
}
