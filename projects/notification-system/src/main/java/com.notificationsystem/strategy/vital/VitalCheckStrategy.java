package com.notificationsystem.strategy.vital;

import com.notificationsystem.enums.SeverityLevel;
import com.notificationsystem.model.VitalSignReading;

public interface VitalCheckStrategy {
    SeverityLevel evaluate(VitalSignReading reading);
}