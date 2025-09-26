package com.notificationsystem.manager;

import com.notificationsystem.model.Notification;
import com.notificationsystem.model.User;
import com.notificationsystem.strategy.channel.NotificationChannel;
import com.notificationsystem.util.AuditLogger;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private final List<NotificationChannel> channels = new ArrayList<>();

    public void registerChannel(NotificationChannel channel) {
        channels.add(channel);
    }

    public void sendToUser(Notification notification, User user) {
        for (NotificationChannel channel : channels) {
            channel.sendNotification(notification, user);
        }

        AuditLogger.log(notification, user);
    }
}