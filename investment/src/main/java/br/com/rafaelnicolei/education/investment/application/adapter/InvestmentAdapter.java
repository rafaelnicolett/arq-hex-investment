package br.com.rafaelnicolei.education.investment.application.adapter;

import br.com.rafaelnicolei.education.investment.application.dto.response.InvestmentResponse;
import br.com.rafaelnicolei.education.investment.domain.model.Investment;

public class InvestmentAdapter {

    public static InvestmentResponse toDtoInvestment(Investment investment) {
        return new InvestmentResponse(investment.getId(),
                investment.getValue(), investment.getCreation());
    }
}
