package com.natife.example.project1.services

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.natife.example.project1.BuildConfig
import com.natife.example.project1.R


class MyService : Service() {

    val NOTIFICATION_CHANNEL_NAME = "Service Notifications"
    val NOTIFICATION_CHANNEL_ID = "service_channel"
    val NOTIFICATION_NAME = "Project1_notification"
    val NOTIFICATION_TEXT = "Touch me"

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        generateForegroundNotification()
        return START_STICKY
    }

    private var notification: Notification? = null
    var mNotificationManager: NotificationManager? = null
    private val mNotificationId = 123

    private fun generateForegroundNotification() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val intentMainLanding = Intent("com.natife.example.project1.MY_NOTIFICATION")
            val pendingIntent =
                PendingIntent.getBroadcast(
                    this,
                    0,
                    intentMainLanding,
                    PendingIntent.FLAG_UPDATE_CURRENT
                )
            if (mNotificationManager == null) {
                mNotificationManager =
                    this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                assert(mNotificationManager != null)
                val notificationChannel =
                    NotificationChannel(
                        NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME,
                        NotificationManager.IMPORTANCE_MIN
                    )
                mNotificationManager?.createNotificationChannel(notificationChannel)
            }

            val builder = NotificationCompat.Builder(this, "service_channel")
            builder.setContentTitle(NOTIFICATION_NAME)
                .setContentText(NOTIFICATION_TEXT)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
            notification = builder.build()
            startForeground(mNotificationId, notification)
        }
    }
}