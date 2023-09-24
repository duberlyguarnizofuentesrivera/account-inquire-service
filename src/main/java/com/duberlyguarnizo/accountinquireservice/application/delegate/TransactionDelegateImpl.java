/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.application.delegate;

import com.duberlyguarnizo.accountinquireservice.application.RestService;
import com.duberlyguarnizo.accountinquireservice.application.dto.TransactionBalanceDto;
import com.duberlyguarnizo.accountinquireservice.application.dto.TransactionCreationDto;
import com.duberlyguarnizo.accountinquireservice.application.dto.TransactionHistoryElementDto;
import com.duberlyguarnizo.accountinquireservice.application.request.TransactionsApi;
import com.duberlyguarnizo.accountinquireservice.application.request.TransactionsApiDelegate;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


/**
 * TransactionDelegateImpl is an implementation of the TransactionsApiDelegate interface.
 * It provides methods for retrieving transaction balance, transaction history,
 * and creating transactions.
 */

@Component
public class TransactionDelegateImpl implements TransactionsApiDelegate {
  private final RestService service;

  public TransactionDelegateImpl(RestService service) {
    this.service = service;
  }

  /**
   * GET /transactions/balance/{accountId}.
   *
   * @param accountId (required)
   * @return Successful Operation (status code 200)
   * @see TransactionsApi#getBalanceByAccountId
   */
  @Override
  public ResponseEntity<TransactionBalanceDto> getBalanceByAccountId(UUID accountId) {
    //TODO: Check and modify according to Mongo ID format.
    TransactionBalanceDto balance = service.getBalanceByAccountId(accountId);
    return ResponseEntity.ok(balance);
  }

  /**
   * GET /transactions/history/{accountId}.
   *
   * @param accountId (required)
   * @return Successful Operation (Http 200)
   * @see TransactionsApi#getAccountTransactionHistory
   */
  @Override
  public ResponseEntity<List<TransactionHistoryElementDto>> getAccountTransactionHistory(
          UUID accountId) {
    return ResponseEntity.ok(service.getTransactionHistory(accountId));
  }

  /**
   * POST /transactions.
   *
   * @param transactionCreationDto (optional)
   * @return Transaction created (status code 201)
   * @see TransactionsApi#createTransaction
   */
  @Override
  public ResponseEntity<UUID> createTransaction(TransactionCreationDto transactionCreationDto) {
    var savedTransactionId = service.createTransaction(transactionCreationDto);
    return ResponseEntity.created(URI.create("/" + savedTransactionId)).build();

  }
}
