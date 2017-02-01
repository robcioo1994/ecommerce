package com.robert.ecommerce.repository;

import com.robert.ecommerce.entity.LoggingEntity;
import org.springframework.data.repository.CrudRepository;

public interface LoggerRepository extends CrudRepository<LoggingEntity, Long> {
}
