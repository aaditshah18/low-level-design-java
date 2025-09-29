package com.notificationsystem.model;

import com.notificationsystem.enums.VitalType;

import java.util.EnumMap;
import java.util.Map;

public class VitalSignReading {
    private final Map<VitalType, Integer> readings = new EnumMap<>(VitalType.class);

    public void setVital(VitalType vitalType, int value) {
        readings.put(vitalType, value);
    }

    public int getVital(VitalType vitalType) {
        return readings.get(vitalType);
    }

    public Map<VitalType, Integer> getAllVitals() {
        return readings;
    }
}