package com.notificationsystem.demo;

import com.notificationsystem.enums.VitalType;
import com.notificationsystem.manager.NotificationService;
import com.notificationsystem.model.*;
import com.notificationsystem.observer.Observer;
import com.notificationsystem.observer.PatientMonitorSubject;
import com.notificationsystem.strategy.channel.EmailChannel;
import com.notificationsystem.strategy.channel.NotificationChannel;
import com.notificationsystem.strategy.channel.PushChannel;
import com.notificationsystem.strategy.channel.SMSChannel;

public class NotificationDemo {
    public static void demo() {
        // Create users
        Doctor doctor = new Doctor("Dr House");
        Nurse nurse = new Nurse("Nurse Patel");

        // Create notification service and register channels
        NotificationService service = new NotificationService();
        service.registerChannel(new EmailChannel());
        service.registerChannel(new SMSChannel());
        service.registerChannel(new PushChannel());

        // Create wiring between subject and observer
        PatientMonitorSubject subject = new PatientMonitorSubject();
        subject.registerObserver(new Observer() {
            @Override
            public void update(Notification notification) {
                service.sendToUser(notification, doctor);
                service.sendToUser(notification, nurse);
            }
        });

        // Patient and reading
        Patient patient = new Patient ();
        patient.setName("Aadit Shah");
        VitalSignReading reading = new VitalSignReading();
        reading.setVital(VitalType.HEART_RATE, 132);
        reading.setVital(VitalType.BLOOD_PRESSURE, 160);
        reading.setVital(VitalType.OXYGEN_SATURATION, 85);
        reading.setVital(VitalType.TEMPERATURE, 98);

        // Monitor delegates to strategies
        VitalSignMonitor monitor = new VitalSignMonitor(subject);
        monitor.checkVitals(patient, reading);
    }
}
