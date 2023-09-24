/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.infrastructure;

import com.duberlyguarnizo.accountinquireservice.domain.model.Transaction;
import com.duberlyguarnizo.accountinquireservice.infrastructure.persistence.TransactionEntity;

/**
 * The TransactionMapper class is a utility class that provides methods for converting
 * Transaction model objects to TransactionEntity objects and vice versa. It is not meant
 * to be instantiated and has only static methods.
 *
 * <p>This class provides the following functionality:</p>
 * <li>Conversion of Transaction model objects to TransactionEntity objects.</li>
 * <li>Conversion of TransactionEntity objects to Transaction model objects.</li>
 */
public final class TransactionMapper {
  private TransactionMapper() {
    // Private constructor... this class has only static methods.
    throw new IllegalStateException("This is a utility class... must not be instantiated.");
  }

  /**
   * Converts a Transaction model object to a TransactionEntity object that
   * can be stored in the database.
   *
   * @param model The Transaction model object to convert.
   * @return The corresponding TransactionEntity object.
   */
  public static TransactionEntity toDbEntity(Transaction model) {
    return TransactionEntity.builder()
            .id(model.getId())
            .amount(model.getTransactionAmount())
            .transactionType(model.getTransactionType())
            .originAccountId(model.getOriginAccountId())
            .destinationAccountId(model.getDestinationAccountId())
            .createdInstant(model.getCreatedInstant())
            .monthlyTransactionCount(model.getMonthlyTransactionCount())
            .currentBalance(model.getCurrentOriginAccountBalance())
            .clientType(model.getClientType())
            .clientSpecialType(model.getClientSpecialType())
            .build();
  }

  /**
   * Converts a TransactionEntity object from the database to a Transaction model object.
   *
   * @param dbEntity The TransactionEntity object to convert.
   * @return The corresponding Transaction model object.
   */
  public static Transaction toModel(TransactionEntity dbEntity) {
    return Transaction.builder()
            .id(dbEntity.getId())
            .transactionAmount(dbEntity.getAmount())
            .transactionType(dbEntity.getTransactionType())
            .originAccountId(dbEntity.getOriginAccountId())
            .destinationAccountId(dbEntity.getDestinationAccountId())
            .monthlyTransactionCount(dbEntity.getMonthlyTransactionCount())
            .currentOriginAccountBalance(dbEntity.getCurrentBalance())
            .clientType(dbEntity.getClientType())
            .clientSpecialType(dbEntity.getClientSpecialType())
            .createdInstant(dbEntity.getCreatedInstant())
            .build();
  }
}
