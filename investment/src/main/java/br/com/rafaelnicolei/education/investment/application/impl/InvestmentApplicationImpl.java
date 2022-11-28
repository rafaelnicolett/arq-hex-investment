package br.com.rafaelnicolei.education.investment.application.impl;

import br.com.rafaelnicolei.education.investment.application.InvestmentApplication;
import br.com.rafaelnicolei.education.investment.application.adapter.InvestmentAdapter;
import br.com.rafaelnicolei.education.investment.application.dto.request.InvestmentRequest;
import br.com.rafaelnicolei.education.investment.application.dto.response.InvestmentResponse;
import br.com.rafaelnicolei.education.investment.domain.model.Investment;
import br.com.rafaelnicolei.education.investment.domain.service.InvestmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvestmentApplicationImpl implements InvestmentApplication {

    private final InvestmentService investmentService;

    @Override
    public InvestmentResponse invest(Long accountId, InvestmentRequest investmentRequest) {
        Investment investment = investmentService.invest(investmentRequest.getProductId(),
                accountId, investmentRequest.getValue());

        return InvestmentAdapter.toDtoInvestment(investment);
    }
}
