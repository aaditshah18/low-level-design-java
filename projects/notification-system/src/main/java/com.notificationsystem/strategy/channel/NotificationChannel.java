package com.notificationsystem.strategy.channel;

import com.notificationsystem.model.Notification;
import com.notificationsystem.model.User;

public interface NotificationChannel {
    void sendNotification(Notification notification, User user);
}