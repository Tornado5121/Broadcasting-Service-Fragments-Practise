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
import com.natife.example.project1.ui.detailedScreen.DetailedFragment
import com.natife.example.project1.ui.itemListScreen.usecases.DisplayItemListUseCase
import com.natife.example.project1.ui.itemListScreen.usecases.SaveDataUseCase

class ItemListFragment : Fragment() {

    private val itemListreducer: ItemListReducer by lazy { ItemListReducer() }
    private val displayItemListUseCase: DisplayItemListUseCase by lazy { DisplayItemListUseCase() }
    private val saveDataUseCase: SaveDataUseCase by lazy { SaveDataUseCase(requireContext()) }

    private lateinit var binding: FragmentListItemBinding

    private val itemListViewModel: ItemListViewModel by lazy {
        ViewModelProvider(viewModelStore, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ItemListViewModel(
                    itemListreducer,
                    listOf(displayItemListUseCase, saveDataUseCase)
                ) as T
            }
        }).get(ItemListViewModel::class.java)
    }

    val adapter = ItemAdapter {
        itemListViewModel.saveIdItemToSharedPrefs(it.id)

        requireActivity().supportFragmentManager.beginTransaction()
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
        itemListViewModel.displayItemList()
        itemListViewModel.state.observe(viewLifecycleOwner, ::renderState)
        init()
    }

    private fun init() {
        binding.itemList.layoutManager = LinearLayoutManager(activity)
        binding.itemList.adapter = adapter
    }

    private fun renderState(newState: MyItemsStates) {
        adapter.submitList(newState.itemListDisplayed)
    }
}