package com.notificationsystem.util;

import com.notificationsystem.model.Notification;
import com.notificationsystem.model.User;

public class AuditLogger {
    public static void log(Notification notification, User user) {
        System.out.println(
                "[AUDIT] " + user.getRole() + " " + user.getUsername()
                        + " was notified with " + notification.getSeverity()
                        + " alert | Message: " + notification.getMessage()
        );
    }
}
