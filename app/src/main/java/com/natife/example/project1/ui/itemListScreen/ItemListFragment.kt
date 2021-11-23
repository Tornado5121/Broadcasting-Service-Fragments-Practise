package com.natife.example.project1.ui.itemListScreen

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.natife.example.project1.R
import com.natife.example.project1.databinding.FragmentListItemBinding
import com.natife.example.project1.ui.detailedScreen.DetailedFragment
import com.natife.example.project1.util.ItemsHolder

class ItemListFragment : Fragment() {


    private val itemListreducer: ItemListReducer = ItemListReducer()
    private val displayItemListUseCase: DisplayItemListUseCase = DisplayItemListUseCase()
    private lateinit var binding: FragmentListItemBinding
    private lateinit var sharedPref: SharedPreferences
    private val viewModel: ItemListViewModel = ItemListViewModel(itemListreducer, displayItemListUseCase)
    val ID_KEY = "id"
    val SHARED_PREF_FILE_NAME = "SharedPrefs"

    val adapter = ItemAdapter {
        saveData(it.id)

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
        viewModel.displayItemList()
        viewModel.state.observe(viewLifecycleOwner, ::renderState)
        init()
    }

    private fun renderState(newState: MyItemsStates) {
        adapter.submitList(newState.itemListDisplayed)
    }

    private fun init() {
        binding.itemList.layoutManager = LinearLayoutManager(activity)
        binding.itemList.adapter = adapter
    }

    private fun saveData(id: Int): SharedPreferences {
        sharedPref = requireActivity().getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putInt(ID_KEY, id)
        editor.apply()
        return sharedPref
    }
}