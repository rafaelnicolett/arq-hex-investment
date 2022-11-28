package br.com.rafaelnicolei.education.investment.integration.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DebitAccountRequest {
    private double valueOfDebit;
}
