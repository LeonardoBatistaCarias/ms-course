package com.leonardobatistacarias.hrpayroll.service.impl;

import com.leonardobatistacarias.hrpayroll.dto.request.PaymentRequest;
import com.leonardobatistacarias.hrpayroll.dto.response.PaymentResponse;
import com.leonardobatistacarias.hrpayroll.dto.response.WorkerResponse;
import com.leonardobatistacarias.hrpayroll.feignclient.WorkerClient;
import com.leonardobatistacarias.hrpayroll.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final WorkerClient workerClient;

    public PaymentServiceImpl(WorkerClient workerClient) {
        this.workerClient = workerClient;
    }

    @Override
    public PaymentResponse getPayment(PaymentRequest request) {
        var worker = this.findWorkerById(request.getWorkderId());
        return new PaymentResponse(worker.getName(), worker.getDailyIncome(), request.getDays());
    }

    private WorkerResponse findWorkerById(Long workerId) {
        var worker = workerClient.findById(workerId).getBody();
        return worker;
    }
}
