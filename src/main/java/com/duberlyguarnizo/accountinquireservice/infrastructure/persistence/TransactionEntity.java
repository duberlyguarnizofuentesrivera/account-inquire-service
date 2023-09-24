/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.infrastructure.persistence;

import com.duberlyguarnizo.accountinquireservice.enums.ClientSpecialType;
import com.duberlyguarnizo.accountinquireservice.enums.ClientType;
import com.duberlyguarnizo.accountinquireservice.enums.TransactionType;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The TransactionEntity class represents a transaction entity.
 * It is used to store information about a transaction in the database.
 */
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document("transactions")
public class TransactionEntity {
  @Id
  private String id;
  private UUID originAccountId;
  private UUID destinationAccountId;
  private double currentBalance;
  private Double amount;
  private Integer monthlyTransactionCount;
  private TransactionType transactionType;
  private ClientType clientType;
  private ClientSpecialType clientSpecialType;
  @ToString.Exclude
  private Instant createdInstant;
}

