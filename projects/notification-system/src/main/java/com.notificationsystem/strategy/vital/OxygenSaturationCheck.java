package com.notificationsystem.strategy.vital;

import com.notificationsystem.enums.SeverityLevel;
import com.notificationsystem.enums.VitalType;
import com.notificationsystem.model.VitalSignReading;

public class OxygenSaturationCheck implements VitalCheckStrategy {

    @Override
    public SeverityLevel evaluate(VitalSignReading reading) {
        int oxygenLevel = reading.getVital(VitalType.OXYGEN_SATURATION);

        if (oxygenLevel < 85) return SeverityLevel.CRITICAL;
        else if (oxygenLevel < 90) return SeverityLevel.HIGH;
        else return SeverityLevel.LOW;
    }
}