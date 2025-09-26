package com.notificationsystem.factory;

import com.notificationsystem.enums.VitalType;
import com.notificationsystem.strategy.vital.*;

import java.util.EnumMap;
import java.util.Map;

public class VitalCheckStrategyFactory {
    private static final Map<VitalType, VitalCheckStrategy> strategies = new EnumMap<>(VitalType.class);
    static {
       strategies.put(VitalType.BLOOD_PRESSURE, new BloodPressureCheck());
       strategies.put(VitalType.HEART_RATE, new HeartRateCheck());
       strategies.put(VitalType.OXYGEN_SATURATION, new OxygenSaturationCheck());
       strategies.put(VitalType.TEMPERATURE, new TemperatureCheck());
    }

    public static VitalCheckStrategy getStrategy(VitalType vitalType) {
        return strategies.get(vitalType);
    }
}