package com.robert.ecommerce.repository;

import com.robert.ecommerce.entity.ProducerEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProducerRepository extends CrudRepository<ProducerEntity, Long> {
}
