package com.natife.example.project1.ui.itemListScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.natife.example.project1.R
import com.natife.example.project1.databinding.FragmentListItemBinding
import com.natife.example.project1.ui.adapters.ItemAdapter
import com.natife.example.project1.ui.detailedScreen.DetailedFragment

class ItemListFragment : Fragment() {
    private lateinit var itemListFragmentViewModel: ItemListFragmentViewModel
    private lateinit var binding: FragmentListItemBinding
    private val adapter = ItemAdapter {

        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_activity_fragment_container, DetailedFragment.newInstance(it.id))
            .addToBackStack("")
            .commit()
        itemListFragmentViewModel.saveItemId(it.id)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        itemListFragmentViewModel = ItemListFragmentViewModel(requireContext())
        super.onViewCreated(view, savedInstanceState)
        binding.itemList.layoutManager = LinearLayoutManager(activity)
        binding.itemList.adapter = adapter
        itemListFragmentViewModel.getItemsListData()
        itemListFragmentViewModel.items.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }
}