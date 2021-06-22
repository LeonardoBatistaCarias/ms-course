package com.leonardobatistacarias.hrpayroll.service.impl;

import com.leonardobatistacarias.hrpayroll.dto.request.PaymentRequest;
import com.leonardobatistacarias.hrpayroll.dto.response.PaymentResponse;
import com.leonardobatistacarias.hrpayroll.dto.response.WorkerResponse;
import com.leonardobatistacarias.hrpayroll.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    private final RestTemplate restTemplate;

    public PaymentServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PaymentResponse getPayment(PaymentRequest request) {
        var worker = this.findWorkerById(request.getWorkderId());
        return new PaymentResponse(worker.getName(), worker.getDailyIncome(), request.getDays());
    }

    private WorkerResponse findWorkerById(Long workerId) {
        var uriVariable = new HashMap<String, String>();
        uriVariable.put("id", String.valueOf(workerId));
        var worker = restTemplate.getForObject(workerHost + "/workers/{id}", WorkerResponse.class, uriVariable);

        return worker;
    }
}
