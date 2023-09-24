/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.duberlyguarnizo.accountinquireservice.application.dto.TransactionCreationDto;
import com.duberlyguarnizo.accountinquireservice.domain.model.Transaction;
import com.duberlyguarnizo.accountinquireservice.domain.service.TransactionService;
import com.duberlyguarnizo.accountinquireservice.enums.ClientSpecialType;
import com.duberlyguarnizo.accountinquireservice.enums.ClientType;
import com.duberlyguarnizo.accountinquireservice.enums.TransactionType;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RestServiceTest {
  @InjectMocks
  private RestService restService;
  @Mock
  private TransactionService transactionService;

  @Test
  void createTransactionIsOkWhenGoodData() {
    TransactionCreationDto dto = TransactionCreationDto.builder()
            .amount(100.0)
            .monthlyTransactionCount(1)
            .originAccountId(UUID.randomUUID())
            .destinationAccountId(UUID.randomUUID())
            .transactionType(TransactionCreationDto.TransactionTypeEnum.DEPOSIT)
            .clientType(TransactionCreationDto.ClientTypeEnum.CORPORATE)
            .clientSpecialType(TransactionCreationDto.ClientSpecialTypeEnum.VIP_CLIENT)
            .currentBalance(9874.3)
            .build();
    Transaction transaction = Transaction.builder()
            .id("123456789123456789")
            .transactionAmount(100.0)
            .monthlyTransactionCount(1)
            .originAccountId(UUID.randomUUID())
            .destinationAccountId(UUID.randomUUID())
            .transactionType(TransactionType.DEPOSIT)
            .clientType(ClientType.CORPORATE)
            .clientSpecialType(ClientSpecialType.VIP_CLIENT)
            .currentOriginAccountBalance(9874.3)
            .createdInstant(Instant.now())
            .build();
    when(transactionService.saveTransaction(any(Transaction.class))).thenReturn(transaction);
    var returnedDtoId = restService.createTransaction(dto);
    assertEquals("123456789123456789", returnedDtoId);
    verify(transactionService, times(1)).saveTransaction(any(Transaction.class));
  }

}