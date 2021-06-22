package com.leonardobatistacarias.hrpayroll.service;

import com.leonardobatistacarias.hrpayroll.dto.request.PaymentRequest;
import com.leonardobatistacarias.hrpayroll.dto.response.PaymentResponse;

public interface PaymentService {

    public PaymentResponse getPayment(PaymentRequest request);
}
