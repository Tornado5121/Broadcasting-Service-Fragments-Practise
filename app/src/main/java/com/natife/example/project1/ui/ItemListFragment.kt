package com.natife.example.project1.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.natife.example.project1.R
import com.natife.example.project1.databinding.FragmentListItemBinding
import com.natife.example.project1.models.Item
import com.natife.example.project1.ui.adapters.ItemAdapter
import com.natife.example.project1.util.ItemsHolder

class ItemListFragment : Fragment() {

    private lateinit var binding: FragmentListItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListItemBinding.inflate(inflater, container, false)


        val adapter = ItemAdapter {
            saveData(it.id)
            sendIntentBroadcast(it.id)

            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_activity_fragment_container, DetailedFragment.newInstance(it.id))
                ?.addToBackStack("")
                ?.commit()
        }
        binding.itemList.layoutManager = LinearLayoutManager(activity)
        binding.itemList.adapter = adapter
        adapter.submitList(ItemsHolder.items)



        return binding.root
    }


    fun saveData(id: Int) {
        val sharedPref = activity?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        sharedPref?.edit {
            putInt("id", id)
        }
    }

    fun sendIntentBroadcast(id: Int) {

        val intentBroadcast = Intent("com.natife.example.project1")
        intentBroadcast.putExtra("name", id)
        activity?.sendBroadcast(intentBroadcast)
    }


}