package br.com.rafaelnicolei.education.investment.integration.impl;

import br.com.rafaelnicolei.education.investment.infrastructure.http.AccountClient;
import br.com.rafaelnicolei.education.investment.integration.AccountIntegration;
import br.com.rafaelnicolei.education.investment.integration.dto.request.DebitAccountRequest;
import br.com.rafaelnicolei.education.investment.integration.valueObject.AccountBalanceVO;
import br.com.rafaelnicolei.education.investment.integration.valueObject.DebitAccountVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountIntegrationImpl implements AccountIntegration {

    private final AccountClient accountClient;

    @Override
    public AccountBalanceVO getAccountBalanceById(Long accountId) {
        AccountBalanceVO accountBalanceVO = accountClient.getAccountBalance(accountId);

        return accountBalanceVO;
    }

    @Override
    public boolean debitAccount(Long accountId, Double valueOfDebit) {
        DebitAccountVO debitAccountVO = accountClient.debit(accountId,
                new DebitAccountRequest(valueOfDebit));

        return debitAccountVO.isDebited();
    }
}
