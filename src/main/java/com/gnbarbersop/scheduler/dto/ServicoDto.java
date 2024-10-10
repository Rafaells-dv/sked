package com.gnbarbersop.scheduler.dto;

import java.sql.Time;

public record ServicoDto(Double price, Time duration, String name) {
}
