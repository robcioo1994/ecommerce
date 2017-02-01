package com.robert.ecommerce.repository;

import com.robert.ecommerce.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    Optional<AccountEntity> findByUsername(String userName);

    Optional<AccountEntity> findByEmail(String email);
}
