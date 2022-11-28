package br.com.rafaelnicolei.education.investment.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorMessageResponse {
    private Date timestamp;
    private String message;
    private String description;
}
