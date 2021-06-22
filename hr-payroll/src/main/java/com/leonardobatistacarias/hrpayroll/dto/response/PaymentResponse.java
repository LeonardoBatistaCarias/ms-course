package com.leonardobatistacarias.hrpayroll.dto.response;

public class PaymentResponse {

    private String name;
    private Double dailyIncome;
    private Integer days;
    private Double total;

    public PaymentResponse() {}

    public PaymentResponse(String name, Double dailyIncome, Integer days) {
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.days = days;
        this.total = days * dailyIncome;
    }

    public String getName() {
        return name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public Integer getDays() {
        return days;
    }

    public double getTotal() {
        return total;
    }

}
