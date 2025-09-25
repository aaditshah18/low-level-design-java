package com.notificationsystem.model;

import com.notificationsystem.enums.SeverityLevel;
import com.notificationsystem.enums.VitalType;
import com.notificationsystem.observer.PatientMonitorSubject;
import com.notificationsystem.strategy.vital.VitalCheckStrategy;

public class VitalSignMonitor {
    private PatientMonitorSubject subject;

    public VitalSignMonitor(PatientMonitorSubject subject) {
        this.subject = subject;
    }

    public void checkVitals(Patient patient, VitalSignReading vitalSignReading) {
        for (VitalType vitalType: VitalType.values()) {
            // Create the required vitalCheckStrategyFactory from the available types
            VitalCheckStrategy vitalCheckStrategy = VitalCheckStrategyFactory.get(vitalType);
            if (vitalCheckStrategy==null) continue;

            // Check the sev level based on current reading
            // If sev level is not low send a notification to the subscribers
            SeverityLevel sevLevel = vitalCheckStrategy.evaluate(vitalSignReading);
            if (sevLevel != SeverityLevel.LOW) {
                subject.notifyObservers(
                        NotificationFactory.createAlert(patient, vitalType, vitalSignReading.getVital(vitalType), sevLevel)
                );
            }

        }

    }

}