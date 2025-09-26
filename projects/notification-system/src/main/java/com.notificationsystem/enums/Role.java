package com.notificationsystem.enums;

public enum Role {
    ROLE_DOCTOR("Doctor"),
    ROLE_NURSE("Nurse"),
    ROLE_STAFF("Staff");

    private final String displayName;

    Role(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {return this.displayName;}
}
