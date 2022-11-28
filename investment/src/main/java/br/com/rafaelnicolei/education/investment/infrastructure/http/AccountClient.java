package br.com.rafaelnicolei.education.investment.infrastructure.http;

import br.com.rafaelnicolei.education.investment.integration.dto.request.DebitAccountRequest;
import br.com.rafaelnicolei.education.investment.integration.valueObject.AccountBalanceVO;
import br.com.rafaelnicolei.education.investment.integration.valueObject.DebitAccountVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "${lab.investment.paths.client-account-name}",
             url = "${lab.investment.paths.client-account-base-url}")
public interface AccountClient {

    @GetMapping("${lab.investment.paths.client-account-balance-path-url}")
    AccountBalanceVO getAccountBalance(@PathVariable("accountId") Long accountId);

    @PostMapping("${lab.investment.paths.client-account-debit-path-url}")
    DebitAccountVO debit(@PathVariable("accountId") Long accountId,
                         DebitAccountRequest debitAccountRequest);

}
