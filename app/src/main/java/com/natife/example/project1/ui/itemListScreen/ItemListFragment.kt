package com.natife.example.project1.ui.itemListScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.natife.example.project1.R
import com.natife.example.project1.databinding.FragmentListItemBinding
import com.natife.example.project1.ui.adapters.ItemAdapter
import com.natife.example.project1.ui.detailedScreen.DetailedFragment

class ItemListFragment : Fragment() {
    private val itemListFragmentViewModel: ItemListFragmentViewModel by lazy {
        ViewModelProvider(viewModelStore, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ItemListFragmentViewModel(requireContext()) as T
            }
        }).get(ItemListFragmentViewModel::class.java)
    }
    private lateinit var binding: FragmentListItemBinding
    private val adapter = ItemAdapter {
        itemListFragmentViewModel.saveItemId(it.id)
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_activity_fragment_container, DetailedFragment.newInstance(it.id))
            .addToBackStack("")
            .commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.itemList.layoutManager = LinearLayoutManager(activity)
        binding.itemList.adapter = adapter
        itemListFragmentViewModel.getItemsListData()
        itemListFragmentViewModel.items.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }
}