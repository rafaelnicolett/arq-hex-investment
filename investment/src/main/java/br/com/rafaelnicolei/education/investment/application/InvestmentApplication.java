package br.com.rafaelnicolei.education.investment.application;

import br.com.rafaelnicolei.education.investment.application.dto.request.InvestmentRequest;
import br.com.rafaelnicolei.education.investment.application.dto.response.InvestmentResponse;

public interface InvestmentApplication {
    InvestmentResponse invest(Long accountId, InvestmentRequest investmentRequest);
}
