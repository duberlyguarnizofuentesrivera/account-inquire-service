/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.domain.repository;

import com.duberlyguarnizo.accountinquireservice.domain.model.Transaction;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionPersistence {
  Transaction save(Transaction transaction);

  List<Transaction> findAll();

  Optional<Transaction> findById(String id);

  List<Transaction> findByOriginAccountId(UUID id);

  void deleteById(String id);
}
