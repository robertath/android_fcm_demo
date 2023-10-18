package com.example.fcm_demo_app

import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class FcmMessagingService: FirebaseMessagingService() {
    private val TAG="FCM-SERVICE"

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.i("FCM_TOKEN", token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        Log.i(TAG, "onMessageReceived Called")
        Log.i(TAG, "onMessageReceived: Message is received from: " + message.from)

        if (message.data.isNotEmpty()) {
            Log.i(TAG, "onMessageReceived: Data: " + message.data.toString())
        }

        if (message.getNotification() != null) {
            Log.i(TAG, "Message Notification Body: " + message.getNotification()!!.getBody());
        }
    }
}
