package com.notificationsystem.factory;

import com.notificationsystem.strategy.channel.EmailChannel;
import com.notificationsystem.strategy.channel.NotificationChannel;
import com.notificationsystem.strategy.channel.PushChannel;
import com.notificationsystem.strategy.channel.SMSChannel;
import com.notificationsystem.exceptions.InvalidChannelException;

public class NotificationChannelFactory {
    public static NotificationChannel getNotificationChannel(String channelName) {
        switch (channelName) {
            case "SMS_CHANNEL": {
                return new SMSChannel();
            }
            case "EMAIL_CHANNEL": {
                return new EmailChannel();
            }
            case "PUSH_CHANNEL": {
                return new PushChannel();
            }
            default: {
                throw new InvalidChannelException("Invalid Channel Provided " + channelName);
            }
        }
    }
}