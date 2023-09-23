/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.accountinquireservice.application.delegate;

import com.duberlyguarnizo.accountinquireservice.application.dto.TransactionBalanceDto;
import com.duberlyguarnizo.accountinquireservice.application.request.TransactionsApi;
import com.duberlyguarnizo.accountinquireservice.application.request.TransactionsApiDelegate;
import org.springframework.http.ResponseEntity;

public class TransactionDelegateImpl implements TransactionsApiDelegate {
  /**
   * GET /transactions/balance/{accountId}
   *
   * @param accountId (required)
   * @return Successful Operation (status code 200)
   * @see TransactionsApi#getBalanceByAccountId
   */
  @Override
  public ResponseEntity<TransactionBalanceDto> getBalanceByAccountId(String accountId) {
    return TransactionsApiDelegate.super.getBalanceByAccountId(accountId);
  }
}
