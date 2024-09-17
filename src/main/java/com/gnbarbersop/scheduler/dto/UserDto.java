package com.gnbarbersop.scheduler.dto;

import com.gnbarbersop.scheduler.entity.UserRole;

public record UserDto(String email, String password, String name, String phone, UserRole role) {
}
