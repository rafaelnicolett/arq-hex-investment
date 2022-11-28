package br.com.rafaelnicolei.education.investment.domain.service;

import br.com.rafaelnicolei.education.investment.domain.model.Investment;

public interface InvestmentService {
    Investment invest(Long productId, Long accountId, Double valueOfInvestment);
}
