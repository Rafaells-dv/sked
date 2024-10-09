package com.gnbarbersop.scheduler.entity.enums;

public enum AppointmentStatus {
    PENDING("PENDING"),
    BOOKED("BOOKED"),
    DONE("DONE");

    private String status;

    AppointmentStatus(String status) {
        this.status = status;
    }
}
