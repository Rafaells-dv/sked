package com.gnbarbersop.scheduler.entity.enums;

import lombok.Getter;

@Getter
public enum UserRole {
    ROLE_ADMIN("admin"),
    ROLE_USER("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

}
