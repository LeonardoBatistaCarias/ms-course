package com.leonardobatistacarias.hrpayroll.dto.request;

public class PaymentRequest {

    private Long workderId;
    private Integer days;

    public PaymentRequest(Long workderId, Integer days) {
        this.workderId = workderId;
        this.days = days;
    }

    public Long getWorkderId() {
        return workderId;
    }

    public Integer getDays() {
        return days;
    }
}
