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
import com.natife.example.project1.ui.detailedScreen.DetailedFragment
import com.natife.example.project1.ui.itemListScreen.ItemListFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    val ID_INTENT_KEY = "id"

    override fun onCreate(savedInstanceState: Bundle?) {
        print(savedInstanceState)
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val fragment = ItemListFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.main_activity_fragment_container, fragment)
            .commit()
        startService(Intent(this, MyService::class.java))
        if (intent.hasExtra(ID_INTENT_KEY)) {
            replaceDetailedFragment()
        }
        registerReceiver(
            ItemBroadcastReceiver(),
            IntentFilter("com.natife.example.project1.MY_NOTIFICATION")
        )
    }

    private fun replaceDetailedFragment() {
        val id = intent.getIntExtra(ID_INTENT_KEY, -1)
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
