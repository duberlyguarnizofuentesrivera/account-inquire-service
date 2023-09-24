/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.infrastructure;

import com.duberlyguarnizo.accountinquireservice.domain.model.Transaction;
import com.duberlyguarnizo.accountinquireservice.infrastructure.persistence.TransactionEntity;

public class TransactionMapper {
  private TransactionMapper() {
    // Private constructor... this class has only static methods.
    throw new IllegalStateException("This is a utility class... must not be instantiated.");
  }

  public static TransactionEntity toDbEntity(Transaction model) {
    return TransactionEntity.builder()
            .id(model.getId())
            .amount(model.getAmount())
            .transactionType(model.getTransactionType())
            .originAccountId(model.getOriginAccountId())
            .destinationAccountId(model.getDestinationAccountId())
            .createdInstant(model.getCreatedInstant())
            .monthlyTransactionCount(model.getMonthlyTransactionCount())
            .currentBalance(model.getCurrentBalance())
            .clientType(model.getClientType())
            .clientSpecialType(model.getClientSpecialType())
            .build();
  }

  public static Transaction toModel(TransactionEntity dbEntity) {
    return Transaction.builder()
            .id(dbEntity.getId())
            .amount(dbEntity.getAmount())
            .transactionType(dbEntity.getTransactionType())
            .originAccountId(dbEntity.getOriginAccountId())
            .destinationAccountId(dbEntity.getDestinationAccountId())
            .monthlyTransactionCount(dbEntity.getMonthlyTransactionCount())
            .currentBalance(dbEntity.getCurrentBalance())
            .clientType(dbEntity.getClientType())
            .clientSpecialType(dbEntity.getClientSpecialType())
            .createdInstant(dbEntity.getCreatedInstant())
            .build();
  }
}
