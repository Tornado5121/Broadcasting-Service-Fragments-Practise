package com.natife.example.project1.services

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.natife.example.project1.BuildConfig
import com.natife.example.project1.ui.MainActivity


class MyService : Service() {

    val ACTION_STOP = "${BuildConfig.APPLICATION_ID}.stop"

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent?.action != null && intent.action.equals(
                ACTION_STOP, ignoreCase = true)) {
            stopForeground(true)
            stopSelf()
        }
        generateForegroundNotification()
        return START_STICKY

    }

    private var iconNotification: Bitmap? = null
    private var notification: Notification? = null
    var mNotificationManager: NotificationManager? = null
    private val mNotificationId = 123

    private fun generateForegroundNotification() {

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val intentMainLanding = Intent(this, MainActivity::class.java)
            val pendingIntent =
                PendingIntent.getActivity(this, 0, intentMainLanding, 0)
//            if (mNotificationManager == null) {
//                mNotificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            }
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                assert(mNotificationManager != null)
//                mNotificationManager?.createNotificationChannelGroup(
//                    NotificationChannelGroup("chats_group", "Chats")
//                )
//                val notificationChannel =
//                    NotificationChannel("service_channel", "Service Notifications",
//                        NotificationManager.IMPORTANCE_MIN)
//                notificationChannel.enableLights(false)
//                notificationChannel.lockscreenVisibility = Notification.VISIBILITY_SECRET
//                mNotificationManager?.createNotificationChannel(notificationChannel)
//            }


            val builder = NotificationCompat.Builder(this, "service_channel")

            builder.setContentTitle(StringBuilder("R.string.app_name").append(" service is running").toString())
                .setContentText("Touch to open") //                    , swipe down for more options.
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setWhen(0)
                .setOnlyAlertOnce(true)
                .setContentIntent(pendingIntent)
                .setOngoing(true)
            if (iconNotification != null) {
                builder.setLargeIcon(Bitmap.createScaledBitmap(iconNotification!!, 128, 128, false))
            }
            notification = builder.build()
            startForeground(mNotificationId, notification)
        }

//    }

}