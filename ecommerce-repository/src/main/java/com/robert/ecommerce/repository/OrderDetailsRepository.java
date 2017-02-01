package com.robert.ecommerce.repository;

import com.robert.ecommerce.entity.OrderDetailsEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailsRepository extends CrudRepository<OrderDetailsEntity, Long> {
}
