package br.com.rafaelnicolei.education.investment.api;

import br.com.rafaelnicolei.education.investment.application.InvestmentApplication;
import br.com.rafaelnicolei.education.investment.application.dto.request.InvestmentRequest;
import br.com.rafaelnicolei.education.investment.application.dto.response.InvestmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class InvestmentController {

    private final InvestmentApplication investmentApplication;

    @PostMapping("/{accountId}/investment")
    public ResponseEntity<InvestmentResponse> invest(
            @PathVariable long accountId,
            @RequestBody InvestmentRequest investmentRequest) {
        InvestmentResponse investmentResponse =
                investmentApplication.invest(accountId, investmentRequest);

        return ResponseEntity.ok(investmentResponse);
    }
}
