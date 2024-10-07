package com.gnbarbersop.scheduler.entity.enums;

public enum HourStatus {
    PENDING("PENDING"),
    SCHEDULED("SCHEDULED"),
    DONE("DONE");

    private String status;

    HourStatus(String status) {
        this.status = status;
    }
}
