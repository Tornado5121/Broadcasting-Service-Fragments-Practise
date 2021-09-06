package com.natife.example.project1.broadcastrecievers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ItemBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Broadcast Intent Detected.", Toast.LENGTH_LONG).show()
    }
}