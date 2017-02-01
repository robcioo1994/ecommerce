package com.robert.ecommerce.repository;

import com.robert.ecommerce.entity.NotebookEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotebookRepository extends PagingAndSortingRepository<NotebookEntity, Long> {

//    Page<NotebookEntity> findAllByCategory(Pageable pageable, Category category);
}
