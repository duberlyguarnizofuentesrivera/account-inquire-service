/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.infrastructure.persistence;

import java.util.List;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * This interface represents a repository for managing transactions with MongoDb.
 * It implements the basic CRUD methods, and other methods can be defined here manually.
 */
public interface TransactionRepository extends MongoRepository<TransactionEntity, String> {
  List<TransactionEntity> findByOriginAccountId(UUID id);
}
