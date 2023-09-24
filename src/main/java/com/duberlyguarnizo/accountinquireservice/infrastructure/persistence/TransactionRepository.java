/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.UUID;


public interface TransactionRepository extends MongoRepository<TransactionEntity, String> {
  List<TransactionEntity> findByOriginAccountId(UUID id);
}
