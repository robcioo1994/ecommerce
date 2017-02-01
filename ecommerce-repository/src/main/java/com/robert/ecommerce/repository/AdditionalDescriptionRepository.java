package com.robert.ecommerce.repository;

import com.robert.ecommerce.entity.DescriptionEntity;
import org.springframework.data.repository.CrudRepository;

public interface AdditionalDescriptionRepository extends CrudRepository<DescriptionEntity, Long> {
}
