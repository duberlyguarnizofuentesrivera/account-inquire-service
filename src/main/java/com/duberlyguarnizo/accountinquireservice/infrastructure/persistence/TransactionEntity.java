/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.infrastructure.persistence;

import com.duberlyguarnizo.accountinquireservice.enums.ClientSpecialType;
import com.duberlyguarnizo.accountinquireservice.enums.ClientType;
import com.duberlyguarnizo.accountinquireservice.enums.TransactionType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@Builder
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
  private Instant createdInstant;
}
