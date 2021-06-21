package com.leonardobatistacarias.hrworker.dto.response.mapper;

import com.leonardobatistacarias.hrworker.dto.response.WorkerResponse;
import com.leonardobatistacarias.hrworker.repository.entity.Worker;

import java.util.List;
import java.util.stream.Collectors;

public interface WorkerResponseMapper {

    static List<WorkerResponse> fromListWorker(List<Worker> list) {
        return list.stream().map(WorkerResponseMapper::fromWorker).collect(Collectors.toList());
    }

    static WorkerResponse fromWorker(Worker worker) {
        return new WorkerResponse(worker.getId(), worker.getName(), worker.getDailyIncome());
    }

}
