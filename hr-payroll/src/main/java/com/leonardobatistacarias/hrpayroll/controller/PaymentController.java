package com.leonardobatistacarias.hrpayroll.controller;

import com.leonardobatistacarias.hrpayroll.dto.request.PaymentRequest;
import com.leonardobatistacarias.hrpayroll.dto.response.PaymentResponse;
import com.leonardobatistacarias.hrpayroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<PaymentResponse> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        var request = new PaymentRequest(workerId, days);
        var response = paymentService.getPayment(request);

        return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<PaymentResponse> getPaymentAlternative(Long workerId, Integer days) {
        var response = new PaymentResponse("Brann", 400.00, days);

        return ResponseEntity.ok().body(response);
    }
}
