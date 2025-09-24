package com.notificationsystem.enums;

public enum VitalType {
    HEART_RATE("Heart Rate"),
    BLOOD_PRESSURE("Blood Pressure"),
    OXYGEN_SATURATION("Oxygen Saturation"),
    TEMPERATURE("Temperature");

    private final String displayName;

    VitalType(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {return this.displayName;}
}
