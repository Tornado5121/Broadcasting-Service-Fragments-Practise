package com.natife.example.project1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.natife.example.project1.ItemModels
import com.natife.example.project1.R
import com.natife.example.project1.databinding.FragmentListItemBinding
import com.natife.example.project1.presenters.ItemPresenter
import com.natife.example.project1.ui.adapters.ItemAdapter
import com.natife.example.project1.util.ItemsHolder

class ItemListFragment : Fragment() {


    private lateinit var binding: FragmentListItemBinding
    private val itemModels by lazy { ItemModels(requireContext()) }
    private lateinit var itemPresenter: ItemPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        itemPresenter = ItemPresenter(itemModels, requireContext())
        binding = FragmentListItemBinding.inflate(inflater, container, false)
        itemPresenter.getListItems()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ItemAdapter {
            itemPresenter.saveIdToSharedPrefs(it.id)

            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_activity_fragment_container, DetailedFragment.newInstance(it.id))
                .addToBackStack("")
                .commit()
        }
        binding.itemList.layoutManager = LinearLayoutManager(activity)
        binding.itemList.adapter = adapter
        adapter.submitList(itemPresenter.getListItems())
    }
}