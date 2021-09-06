package com.natife.example.project1.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.natife.example.project1.databinding.FragmentDetailedBinding

class DetailedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = FragmentDetailedBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val idTextValue = intent.getStringExtra("id").toString()
        val nameTextValue = intent.getStringExtra("name").toString()
        val descriptionTextValue = intent.getStringExtra("description").toString()

        binding.idTextView.text = idTextValue
        binding.nameTextView.text = nameTextValue
        binding.descriptionTextView.text = descriptionTextValue
    }
}