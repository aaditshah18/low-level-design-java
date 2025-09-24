package com.notificationsystem.strategy.vital;

import com.notificationsystem.enums.SeverityLevel;
import com.notificationsystem.enums.VitalType;
import com.notificationsystem.model.VitalSignReading;

public class TemperatureCheck implements VitalCheckStrategy {

    @Override
    public SeverityLevel evaluate(VitalSignReading reading) {
        int temperature = reading.getVital(VitalType.TEMPERATURE);

        if (temperature > 105) return SeverityLevel.CRITICAL;
        else if (temperature > 100) return SeverityLevel.HIGH;
        else return SeverityLevel.LOW;
    }
}