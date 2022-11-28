package br.com.rafaelnicolei.education.investment.integration.valueObject;

import lombok.Data;

@Data
public class AccountBalanceVO {
    private Long accountId;

    private double balance;
}
