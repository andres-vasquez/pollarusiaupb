package com.pollarusia2018.pollaupb.fcm;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by andresvasquez on 12/6/17.
 */

public class PollaMessagingService extends FirebaseMessagingService{

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String messageId = remoteMessage.getMessageId();
        String titulo = remoteMessage.getNotification().getTitle();
        String message = remoteMessage.getNotification().getBody();
    }
}
