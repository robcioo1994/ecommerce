package com.robert.ecommerce.repository;

import com.robert.ecommerce.entity.MemoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface MemoryRepository extends CrudRepository<MemoryEntity, Long> {
}
