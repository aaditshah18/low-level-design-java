package com.notificationsystem.strategy.vital;

import com.notificationsystem.enums.SeverityLevel;
import com.notificationsystem.enums.VitalType;
import com.notificationsystem.model.VitalSignReading;

public class BloodPressureCheck implements VitalCheckStrategy {

    @Override
    public SeverityLevel evaluate(VitalSignReading reading) {
        int bpSystolic = reading.getVital(VitalType.TEMPERATURE);

        if (bpSystolic > 160) return SeverityLevel.CRITICAL;
        else if (bpSystolic > 145) return SeverityLevel.HIGH;
        else if (bpSystolic > 125) return SeverityLevel.MEDIUM;
        else return SeverityLevel.LOW;
    }
}