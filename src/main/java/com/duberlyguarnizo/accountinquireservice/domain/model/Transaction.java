/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.domain.model;

import com.duberlyguarnizo.accountinquireservice.architecture.DomainModel;
import com.duberlyguarnizo.accountinquireservice.enums.ClientSpecialType;
import com.duberlyguarnizo.accountinquireservice.enums.ClientType;
import com.duberlyguarnizo.accountinquireservice.enums.TransactionType;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Represents a transaction between two accounts.
 * This class provides information about the transaction, such as the transaction ID,
 * origin and destination account IDs, current balance, transaction amount, monthly
 * transaction count, transaction type, client type, client special type,
 * and the instant when the transaction was created.
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@DomainModel
public class Transaction {
  private String id;
  private UUID originAccountId;
  private UUID destinationAccountId;
  private double currentOriginAccountBalance;
  private Double transactionAmount;
  private Integer monthlyTransactionCount;
  private TransactionType transactionType;
  private ClientType clientType;
  private ClientSpecialType clientSpecialType;
  @ToString.Exclude
  private Instant createdInstant;
}
