package com.leonardobatistacarias.hrpayroll.feignclient;

import com.leonardobatistacarias.hrpayroll.dto.response.WorkerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers")
public interface WorkerClient {

    @GetMapping("/{id}")
    public ResponseEntity<WorkerResponse> findById(@PathVariable Long id);
}
