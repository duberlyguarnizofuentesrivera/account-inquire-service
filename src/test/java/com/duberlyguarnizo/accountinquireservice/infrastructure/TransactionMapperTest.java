/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.infrastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.duberlyguarnizo.accountinquireservice.domain.model.Transaction;
import com.duberlyguarnizo.accountinquireservice.enums.ClientSpecialType;
import com.duberlyguarnizo.accountinquireservice.enums.ClientType;
import com.duberlyguarnizo.accountinquireservice.enums.TransactionType;
import com.duberlyguarnizo.accountinquireservice.infrastructure.persistence.TransactionEntity;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class TransactionMapperTest {
  TransactionEntity entity;
  Transaction transaction;
  String defaultId;
  UUID originId;
  UUID destinationId;
  TransactionType randomTransactionType;
  ClientType randomClientType;
  ClientSpecialType randomClientSpecialType;


  @BeforeEach
  void setUp() {
    defaultId = "55b4fda5830b550a8c2ca25a";
    double defaultAmount = 54.9;
    double defaultBalance = 894.6;
    originId = UUID.randomUUID();
    destinationId = UUID.randomUUID();
    randomTransactionType = TransactionType.values()[(int) (Math.random() * TransactionType.values().length)];
    randomClientType = ClientType.values()[(int) (Math.random() * ClientType.values().length)];
    randomClientSpecialType = ClientSpecialType.values()[(int) (Math.random() * ClientSpecialType.values().length)];

    entity = TransactionEntity.builder()
            .id(defaultId)
            .amount(defaultAmount)
            .originAccountId(originId)
            .destinationAccountId(destinationId)
            .currentBalance(defaultBalance)
            .monthlyTransactionCount(5)
            .createdInstant(Instant.now())
            .transactionType(randomTransactionType)
            .clientType(randomClientType)
            .clientSpecialType(randomClientSpecialType)
            .build();

    transaction = Transaction.builder()
            .id(defaultId)
            .amount(defaultAmount)
            .originAccountId(originId)
            .destinationAccountId(destinationId)
            .currentBalance(defaultBalance)
            .monthlyTransactionCount(5)
            .createdInstant(Instant.now())
            .transactionType(randomTransactionType)
            .clientType(randomClientType)
            .clientSpecialType(randomClientSpecialType)
            .build();
  }

  @Test
  @DisplayName("Convert from Transaction to Entity works with valid data")
  void convertFromTransactionToEntityWorksWithValidData() {
    TransactionEntity result = TransactionMapper.toDbEntity(transaction);
    // Test against toString() because creation datetime is always different, and is not part of toString().
    assertEquals(entity.toString(), result.toString());
  }

  @Test
  @DisplayName("Convert from Entity to Transaction works with valid data")
  void convertFromEntityToTransactionWorksWithValidData() {
    Transaction result = TransactionMapper.toModel(entity);
    assertEquals(transaction.toString(), result.toString());
  }
}