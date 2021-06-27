package com.leonardobatistacarias.hrworker.controller;

import com.leonardobatistacarias.hrworker.dto.response.WorkerResponse;
import com.leonardobatistacarias.hrworker.service.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    private final WorkerService workerService;
    private final Environment env;

    public WorkerController(WorkerService workerService, Environment env) {
        this.workerService = workerService;
        this.env = env;
    }

    @GetMapping
    public ResponseEntity<List<WorkerResponse>> findAll() {
        var response = workerService.findAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerResponse> findById(@PathVariable Long id) {
        logger.info("PORT = " + env.getProperty("local.server.port"));
        var response = workerService.findById(id);
        return ResponseEntity.ok().body(response);
    }
}
