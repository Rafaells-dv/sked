package com.gnbarbersop.scheduler.dto;

import com.gnbarbersop.scheduler.entity.enums.UserRole;

public record UserDto(String email, String password, String name, String phone, UserRole role) {
}
