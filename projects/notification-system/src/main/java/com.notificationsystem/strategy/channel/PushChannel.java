package com.notificationsystem.strategy.channel;

import com.notificationsystem.model.Notification;
import com.notificationsystem.model.User;

public class PushChannel implements NotificationChannel {

    @Override
    public void sendNotification(Notification notification, User user) {
        String message = String.format(
                "[PUSH] To: %s (%s) | %s | Severity: %s",
                user.getUsername(), user.getRole(),
                notification.getMessage(), notification.getSeverity()
        );
        System.out.println(message);
    }
}