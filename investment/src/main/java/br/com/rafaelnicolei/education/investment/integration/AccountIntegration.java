package br.com.rafaelnicolei.education.investment.integration;

import br.com.rafaelnicolei.education.investment.integration.valueObject.AccountBalanceVO;

public interface AccountIntegration {

    AccountBalanceVO getAccountBalanceById(Long accountId);

    boolean debitAccount(Long accountId, Double valueOfDebit);
}
