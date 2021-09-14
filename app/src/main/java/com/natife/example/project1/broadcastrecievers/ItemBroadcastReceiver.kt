package com.natife.example.project1.broadcastrecievers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import com.natife.example.project1.ui.MainActivity

class ItemBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {

        context.also {
            val id = getSharedPrefsId(it)
            val intent = Intent(it, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("id", id)
            it.startActivity(intent)
        }
    }

    private fun getSharedPrefsId(context: Context): Int {
        val sharedPref = context.getSharedPreferences("SharedPrefs", MODE_PRIVATE)
        return sharedPref.getInt("id", -1)
    }
}
