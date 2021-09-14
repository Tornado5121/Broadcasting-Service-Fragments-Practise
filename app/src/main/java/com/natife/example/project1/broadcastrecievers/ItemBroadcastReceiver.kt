package com.natife.example.project1.broadcastrecievers

import android.content.*
import android.content.Context.MODE_PRIVATE
import com.natife.example.project1.ui.MainActivity
import com.natife.example.project1.util.ItemsHolder

class ItemBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        context?.also {
            val id = getSharedPrefsId(it)
            val intent = Intent(it, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("id", id)
            it.startActivity(intent)
        }
    }

    private fun getSharedPrefsId(context: Context): Int {
        val sharedPref = context.getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        return sharedPref.getInt("id", -1)
    }
}
