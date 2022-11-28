package br.com.rafaelnicolei.education.investment.api.handler;

import br.com.rafaelnicolei.education.investment.application.dto.response.ErrorMessageResponse;
import br.com.rafaelnicolei.education.investment.domain.exception.InvestmentAccountIsNotDebitException;
import br.com.rafaelnicolei.education.investment.domain.exception.InvestmentAccountWithoutBalanceException;
import br.com.rafaelnicolei.education.investment.domain.exception.InvestmentAccountWithoutBalanceForProductPrivateInvestment;
import br.com.rafaelnicolei.education.investment.domain.exception.InvestmentProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class InvestmentExceptionHandler {

    private final String MESSAGE_ERROR_INTERNAL = "Erro interno!";
    private final String DESCRIPTION_ERROR_INTERNAL = "Serviço temporariamente indisponível, tente novamente mais tarde!";

    @Value("${lab.investment.exceptions.product-dont-exists-message}")
    private String messageExceptionProductNotFound;

    @Value("${lab.investment.exceptions.product-dont-exists-description}")
    private String descriptionExceptionProductNotFound;

    @Value("${lab.investment.exceptions.account-without-balance-message}")
    private String messageExceptionAccountWithoutBalance;

    @Value("${lab.investment.exceptions.account-without-balance-description}")
    private String descriptionExceptionAccountWithoutBalance;

    @Value("${lab.investment.exceptions.account-without-balance-for-product-private-message}")
    private String messageExceptionAccountWithoutBalanceForPrivateInvestment;

    @Value("${lab.investment.exceptions.account-without-balance-for-product-private-description}")
    private String descriptionExceptionAccountWithoutBalanceForPrivateInvestment;

    @Value("${lab.investment.exceptions.account-is-not-debited-message}")
    private String messageExceptionDebitedAccount;

    @Value("${lab.investment.exceptions.account-is-not-debited-description}")
    private String descriptionExceptionDebitedAccount;

    @ExceptionHandler(InvestmentProductNotFoundException.class)
    public ResponseEntity<ErrorMessageResponse> errorProductNotFound() {
        return getErrorResponse(
                messageExceptionProductNotFound,
                descriptionExceptionProductNotFound,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvestmentAccountWithoutBalanceException.class)
    public ResponseEntity<ErrorMessageResponse> errorWithoutBalance() {
        return getErrorResponse(
                messageExceptionAccountWithoutBalance,
                descriptionExceptionAccountWithoutBalance,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvestmentAccountWithoutBalanceForProductPrivateInvestment.class)
    public ResponseEntity<ErrorMessageResponse> errorWithoutBalanceForProductPrivate() {
        return getErrorResponse(
                messageExceptionAccountWithoutBalanceForPrivateInvestment,
                descriptionExceptionAccountWithoutBalanceForPrivateInvestment,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvestmentAccountIsNotDebitException.class)
    public ResponseEntity<ErrorMessageResponse> errorDebitAccount() {
        return getErrorResponse(
                messageExceptionDebitedAccount,
                descriptionExceptionDebitedAccount,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessageResponse> errorGeneral() {
        return getErrorResponse(MESSAGE_ERROR_INTERNAL,
                DESCRIPTION_ERROR_INTERNAL,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorMessageResponse> getErrorResponse(String message,
                                                                  String description,
                                                                  HttpStatus httpStatus) {
        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
                new Date(),
                message,
                description
        );

        return new ResponseEntity<>(errorMessageResponse, httpStatus);
    }
}
