package com.natife.example.project1.ui

import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.natife.example.project1.R
import com.natife.example.project1.broadcastrecievers.ItemBroadcastReceiver
import com.natife.example.project1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    var receiver: ItemBroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val fragment = ItemListFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.main_activity_fragment_container, fragment)
            .commit()

        configureReceiver()

    }

    private fun configureReceiver() {
        val filter = IntentFilter()
        filter.addAction("me.proft.sendbroadcast")
        receiver = ItemBroadcastReceiver()
        registerReceiver(receiver, filter)
    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}
