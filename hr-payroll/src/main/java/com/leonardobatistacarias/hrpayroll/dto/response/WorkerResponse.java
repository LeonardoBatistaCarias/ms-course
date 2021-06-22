package com.leonardobatistacarias.hrpayroll.dto.response;

public class WorkerResponse {

    private Long id;
    private String name;
    private Double dailyIncome;

    public WorkerResponse() {
    }

    public WorkerResponse(Long id, String name, Double dailyIncome) {
        this.id = id;
        this.name = name;
        this.dailyIncome = dailyIncome;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }
}
