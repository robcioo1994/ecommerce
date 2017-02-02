package com.robert.ecommerce.repository;

import com.robert.ecommerce.entity.DisplayTypeEntity;
import com.robert.ecommerce.entity.LoggingEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

public interface LoggerRepository extends CrudRepository<LoggingEntity, Long> {

//    @Query("select n.id, (n.displayResolution.width * n.displayResolution.hight), n.hardDisc.size, l.time  form notebook n join  logger l on l.productId = n.id")
    @Query("select u from DisplayTypeEntity u")
    Stream<DisplayTypeEntity> getRecords();

}
