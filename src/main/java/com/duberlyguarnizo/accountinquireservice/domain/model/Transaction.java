/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.domain.model;

import com.duberlyguarnizo.accountinquireservice.enums.ClientSpecialType;
import com.duberlyguarnizo.accountinquireservice.enums.ClientType;
import com.duberlyguarnizo.accountinquireservice.enums.TransactionType;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.UUID;

@Data
@Builder
public class Transaction {
  private String id;
  private UUID originAccountId;//
  private UUID destinationAccountId;//
  private double currentBalance;//
  private Double amount;//
  private Integer monthlyTransactionCount;//
  private TransactionType transactionType;//
  private ClientType clientType;//
  private ClientSpecialType clientSpecialType;//
  private Instant createdInstant;
}
