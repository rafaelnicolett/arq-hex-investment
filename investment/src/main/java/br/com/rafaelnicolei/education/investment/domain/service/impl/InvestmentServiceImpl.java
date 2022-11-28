package br.com.rafaelnicolei.education.investment.domain.service.impl;

import br.com.rafaelnicolei.education.investment.domain.exception.InvestmentAccountIsNotDebitException;
import br.com.rafaelnicolei.education.investment.domain.exception.InvestmentProductNotFoundException;
import br.com.rafaelnicolei.education.investment.domain.model.Investment;
import br.com.rafaelnicolei.education.investment.domain.model.Product;
import br.com.rafaelnicolei.education.investment.domain.service.InvestmentService;
import br.com.rafaelnicolei.education.investment.infrastructure.repository.InvestmentRepository;
import br.com.rafaelnicolei.education.investment.infrastructure.repository.ProductRepository;
import br.com.rafaelnicolei.education.investment.integration.AccountIntegration;
import br.com.rafaelnicolei.education.investment.integration.valueObject.AccountBalanceVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvestmentServiceImpl implements InvestmentService {

    private final ProductRepository productRepository;

    private final InvestmentRepository investmentRepository;

    private final AccountIntegration accountIntegration;

    @Override
    public Investment invest(Long productId, Long accountId, Double valueOfInvestment) {
        Optional<Product> product = productRepository.findById(productId);

        if (product.isEmpty())
            throw new InvestmentProductNotFoundException();

        Investment investment = new Investment(productId, accountId, valueOfInvestment);

        AccountBalanceVO accountBalanceVO = accountIntegration.getAccountBalanceById(accountId);

        investment.checkSufficientBalanceForInvestment(accountBalanceVO.getBalance());

        investment.verifyProductPrivateOrDefaultForInvestment(accountBalanceVO.getBalance(),
                                                                product.get());

        boolean isDebited = accountIntegration.debitAccount(accountId, investment.getValue());

        if (!isDebited)
            throw new InvestmentAccountIsNotDebitException();

        investmentRepository.save(investment);

        return investment;
    }
}
