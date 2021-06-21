package com.leonardobatistacarias.hrworker.service;

import com.leonardobatistacarias.hrworker.dto.response.WorkerResponse;

import java.util.List;

public interface WorkerService {

    public List<WorkerResponse> findAll();

    public WorkerResponse findById(Long id);

}
