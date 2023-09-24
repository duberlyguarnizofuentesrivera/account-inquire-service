/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.application;

import com.duberlyguarnizo.accountinquireservice.application.dto.TransactionBalanceDto;
import com.duberlyguarnizo.accountinquireservice.application.dto.TransactionCreationDto;
import com.duberlyguarnizo.accountinquireservice.application.dto.TransactionHistoryElementDto;
import com.duberlyguarnizo.accountinquireservice.domain.model.Transaction;
import com.duberlyguarnizo.accountinquireservice.domain.service.TransactionService;
import com.duberlyguarnizo.accountinquireservice.enums.ClientSpecialType;
import com.duberlyguarnizo.accountinquireservice.enums.ClientType;
import com.duberlyguarnizo.accountinquireservice.enums.TransactionType;
import com.duberlyguarnizo.accountinquireservice.exception.TransactionPersistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * The RestService  is responsible for performing conversion between DTOs and domain
 * entities related to transactions. These methods are to be used by the controllers
 * via the ApiDelegate implementation.
 */
@RequiredArgsConstructor
@Service
public class RestService {
  private final TransactionService service;

  /**
   * Retrieves the balance and total number of transactions for a given account ID.
   *
   * @param accountId The ID of the account.
   * @return A TransactionBalanceDto object containing the total number of transactions
   *         and the average balance.
   */
  public TransactionBalanceDto getBalanceByAccountId(UUID accountId) {
    double avgBalance;
    var transactionList = service.getTransactionsByAccountId(accountId);
    avgBalance = transactionList.stream()
            .mapToDouble(Transaction::getCurrentBalance).average().orElse(Double.NaN);
    return TransactionBalanceDto.builder()
            .totalTransactions(transactionList.size())
            .avgBalance(avgBalance)
            .build();
  }

  /**
   * Retrieves the transaction history for the specified account ID.
   *
   * @param accountId The ID of the account.
   * @return A list of TransactionHistoryElementDto objects representing the transaction history.
   */
  public List<TransactionHistoryElementDto> getTransactionHistory(UUID accountId) {
    return service.getTransactionsByAccountId(accountId).stream().map(tr ->
            TransactionHistoryElementDto.builder()
                    .amount(tr.getAmount())
                    .createdInstant(OffsetDateTime.from(tr.getCreatedInstant()))
                    .destinationAccountId(tr.getDestinationAccountId())
                    .transactionType(TransactionHistoryElementDto.TransactionTypeEnum.valueOf(
                            tr.getTransactionType().name()))
                    .build()
    ).collect(Collectors.toList());
  }

  /**
   * Creates a transaction based on the given TransactionCreationDto.
   *
   * @param dto the TransactionCreationDto object holding the transaction details
   * @return the original TransactionCreationDto object
   * @throws TransactionPersistenceException if there was an error while saving the transaction
   */
  public String createTransaction(TransactionCreationDto dto) {
    var transactionFromDto = Transaction.builder()
            .transactionType(TransactionType.valueOf(dto.getTransactionType().name()))
            .currentBalance(dto.getCurrentBalance())
            .clientSpecialType(ClientSpecialType.valueOf(dto.getClientSpecialType().name()))
            .clientType(ClientType.valueOf(dto.getClientType().name()))
            .monthlyTransactionCount(dto.getMonthlyTransactionCount())
            .originAccountId(dto.getOriginAccountId())
            .destinationAccountId(dto.getDestinationAccountId())
            .amount(dto.getAmount())
            .createdInstant(Instant.now())
            .build();
    var transaction = service.saveTransaction(transactionFromDto);
    if (transaction == null) {
      throw new TransactionPersistenceException("There was an error while saving");
    }
    return transaction.getId();

  }
}
