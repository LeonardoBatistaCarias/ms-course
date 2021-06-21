package com.leonardobatistacarias.hrworker.service.impl;

import com.leonardobatistacarias.hrworker.dto.response.WorkerResponse;
import com.leonardobatistacarias.hrworker.dto.response.mapper.WorkerResponseMapper;
import com.leonardobatistacarias.hrworker.repository.WorkerRepository;
import com.leonardobatistacarias.hrworker.service.WorkerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<WorkerResponse> findAll() {
        var list = workerRepository.findAll();
        return WorkerResponseMapper.fromListWorker(list);
    }

    @Override
    public WorkerResponse findById(Long id) {
        var worker = workerRepository.findById(id);

        return WorkerResponseMapper.fromWorker(worker.get());
    }
}

