package com.leonardobatistacarias.hrpayroll.service.impl;

import com.leonardobatistacarias.hrpayroll.dto.request.PaymentRequest;
import com.leonardobatistacarias.hrpayroll.dto.response.PaymentResponse;
import com.leonardobatistacarias.hrpayroll.entity.Payment;
import com.leonardobatistacarias.hrpayroll.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public PaymentResponse getPayment(PaymentRequest request) {
        return new PaymentResponse("Bob", 200.00, request.getDays());
    }
}
