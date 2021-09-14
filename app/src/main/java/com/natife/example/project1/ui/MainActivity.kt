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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val fragment = ItemListFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.main_activity_fragment_container, fragment)
            .commit()
        startService(Intent(this, MyService::class.java))
        startDetailedFragment()

        registerReceiver(
            ItemBroadcastReceiver(),
            IntentFilter("com.natife.example.project1.MY_NOTIFICATION")
        )
    }

    private fun startDetailedFragment() {
        if (intent.hasExtra("id")) {
            val id = intent.getIntExtra("id", -1)
            if (id >= 0) {
                supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.main_activity_fragment_container,
                        DetailedFragment.newInstance(id)
                    )
                    .addToBackStack("")
                    .remove(ItemListFragment())
                    .commit()
            }
        }
    }
}
