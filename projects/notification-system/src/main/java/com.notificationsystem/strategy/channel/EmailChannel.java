package com.notificationsystem.strategy.channel;

import com.notificationsystem.model.Notification;
import com.notificationsystem.model.User;

public class EmailChannel implements NotificationChannel {

    @Override
    public void sendNotification(Notification notification, User user) {
        String message = String.format("[EMAIL] to %s | %s | Severity %s",
                user.getUsername(), notification.getMessage(), notification.getSeverity());
        System.out.println(message);
    }
}