package com.natife.example.project1.ui

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.natife.example.project1.R
import com.natife.example.project1.broadcastrecievers.ItemBroadcastReceiver
import com.natife.example.project1.databinding.ActivityMainBinding
import com.natife.example.project1.services.MyService

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
        startService(Intent(this, MyService::class.java))
    }

    private fun configureReceiver() {
        val filter = IntentFilter()
        filter.addAction("com.natife.example.project1")
        receiver = ItemBroadcastReceiver()
        registerReceiver(receiver, filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
}
