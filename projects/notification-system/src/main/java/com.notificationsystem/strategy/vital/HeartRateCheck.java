package com.notificationsystem.strategy.vital;

import com.notificationsystem.enums.SeverityLevel;
import com.notificationsystem.enums.VitalType;
import com.notificationsystem.model.VitalSignReading;

public class HeartRateCheck implements VitalCheckStrategy {
    @Override
    public SeverityLevel evaluate(VitalSignReading vitalSignReading) {
        int hr = vitalSignReading.getVital(VitalType.HEART_RATE);
        if (hr > 150) return SeverityLevel.CRITICAL;
        else if (hr > 120) return SeverityLevel.HIGH;
        else if (hr > 100) return SeverityLevel.MEDIUM;
        else return SeverityLevel.LOW;

    }
}
