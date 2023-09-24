/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.infrastructure.persistence;

import com.duberlyguarnizo.accountinquireservice.domain.model.Transaction;
import com.duberlyguarnizo.accountinquireservice.domain.repository.TransactionPersistence;
import com.duberlyguarnizo.accountinquireservice.infrastructure.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * This class implements the TransactionPersistence interface and provides the implementation
 * for persisting and retrieving Transaction objects from the database.
 */
@Component
public class TransactionPersistenceImpl implements TransactionPersistence {

  private TransactionRepository repository;

  @Override
  public Transaction save(Transaction transaction) {
    TransactionEntity result = repository.save(TransactionMapper.toDbEntity(transaction));
    return TransactionMapper.toModel(result);
  }

  @Override
  public List<Transaction> findAll() {
    return repository.findAll()
            .stream()
            .map(TransactionMapper::toModel)
            .collect(Collectors.toList());
  }

  @Override
  public Optional<Transaction> findById(String id) {
    return repository.findById(id).map(TransactionMapper::toModel);
  }

  @Override
  public List<Transaction> findByOriginAccountId(UUID id) {
    return repository.findByOriginAccountId(id)
            .stream()
            .map(TransactionMapper::toModel)
            .collect(Collectors.toList());
  }

  @Override
  public void deleteById(String id) {
    repository.deleteById(id);
  }

  @Autowired
  public void setRepository(TransactionRepository repository) {
    this.repository = repository;
  }
}
