/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.domain.service;

import com.duberlyguarnizo.accountinquireservice.domain.model.Transaction;
import com.duberlyguarnizo.accountinquireservice.domain.repository.TransactionPersistence;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * The TransactionService class provides methods for retrieving, saving, and deleting transactions.
 * Its main purpose is to create a link between the application and domain layers.
 */

@Service
public class TransactionService {
  private final TransactionPersistence persistence;

  public TransactionService(TransactionPersistence persistence) {
    this.persistence = persistence;
  }

  public List<Transaction> getAllTransactions() {
    return persistence.findAll();
  }

  public List<Transaction> getTransactionsByAccountId(UUID accountId) {
    return persistence.findByOriginAccountId(accountId);
  }

  public Optional<Transaction> getTransactionByTransactionId(String id) {
    return persistence.findById(id);
  }

  public Transaction saveTransaction(Transaction transaction) {
    return persistence.save(transaction);
  }

  public void deleteTransactionById(String id) {
    persistence.deleteById(id);
  }

}
