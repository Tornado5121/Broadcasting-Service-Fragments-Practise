package com.natife.example.project1.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.natife.example.project1.R
import com.natife.example.project1.databinding.FragmentListItemBinding
import com.natife.example.project1.models.Item
import com.natife.example.project1.services.MyService
import com.natife.example.project1.ui.adapters.ItemAdapter
import com.natife.example.project1.util.ItemsHolder

class ItemListFragment : Fragment() {

    private lateinit var binding: FragmentListItemBinding
    private lateinit var sharedPref:SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListItemBinding.inflate(inflater, container, false)
        val adapter = ItemAdapter {
            saveData(it.id)

            it.id?.let { it1 -> DetailedFragment.newInstance(it1) }?.let { it2 ->
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.main_activity_fragment_container,
                        it2
                    )
                    ?.addToBackStack("")
                    ?.commit()
            }
        }
        binding.itemList.layoutManager = LinearLayoutManager(activity)
        binding.itemList.adapter = adapter
        adapter.submitList(ItemsHolder.items)

        return binding.root
    }

    fun saveData(id: Int?) :SharedPreferences? {
        sharedPref = activity?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)!!
        sharedPref.edit {
            id?.let { putInt("id", it) }
        }
        return sharedPref
    }
}