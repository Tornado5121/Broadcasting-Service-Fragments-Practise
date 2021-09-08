package com.natife.example.project1.broadcastrecievers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ItemBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Broadcast Intent Detected", Toast.LENGTH_LONG).show()

//        val intent = Intent(this@MainActivity, TimeReminderReceiver::class.java)
//        val pendingIntent = PendingIntent.getBroadcast(this@MainActivity, 0, intent,
//            PendingIntent.FLAG_UPDATE_CURRENT)
//        val am = this@MainActivity.getSystemService(Context.ALARM_SERVICE) as AlarmManager
//        am.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
    }
}