package com.robert.ecommerce.repository;

import com.robert.ecommerce.entity.OrdersEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<OrdersEntity, Long> {
}
