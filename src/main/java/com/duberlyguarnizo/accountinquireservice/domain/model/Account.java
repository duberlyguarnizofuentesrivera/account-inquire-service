/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.domain.model;

import com.duberlyguarnizo.accountinquireservice.enums.ClientType;
import lombok.Data;
import java.util.UUID;

@Data
public class Account {
  private UUID holderId;
  private ClientType clientType;
  private Double balance;
  private UUID accountNumber;
  private Integer monthlyTransactionCount;
}
