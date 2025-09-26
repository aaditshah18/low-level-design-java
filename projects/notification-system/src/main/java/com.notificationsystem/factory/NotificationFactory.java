package com.notificationsystem.factory;

import com.notificationsystem.enums.SeverityLevel;
import com.notificationsystem.enums.VitalType;
import com.notificationsystem.model.Notification;
import com.notificationsystem.model.Patient;

public class NotificationFactory {
    public static Notification createNotification(Patient patient, VitalType vitalType, int value, SeverityLevel severityLevel) {
        String message = String.format("ALERT: Patient %s has abnormal %s - %d. Patient ID - %s",
                patient.getName(), vitalType, value, patient.getId());
        return new Notification(message, severityLevel);
    }
}