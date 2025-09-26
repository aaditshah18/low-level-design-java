package com.notificationsystem.model;

import com.notificationsystem.enums.SeverityLevel;
import com.notificationsystem.util.IdGenerator;

public class Notification {
    private String id;
    private final String message;
    private final SeverityLevel severity;

    public Notification(String message, SeverityLevel severity) {
        this.id = IdGenerator.generateId();
        this.message = message;
        this.severity = severity;
    }

    public String getId() {return this.id;}
    public String getMessage() {return this.message;}
    public SeverityLevel getSeverity() {return this.severity;}

}