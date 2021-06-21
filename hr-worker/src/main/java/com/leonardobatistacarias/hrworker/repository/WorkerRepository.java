package com.leonardobatistacarias.hrworker.repository;

import com.leonardobatistacarias.hrworker.repository.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
