package com.natife.example.project1.ui.itemListScreen

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natife.example.project1.models.ItemRepository
import com.natife.example.project1.models.Item

class ItemListFragmentViewModel(context: Context) : ViewModel() {

    private val itemRepository = ItemRepository(context)
    private val mutableItems = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = mutableItems

    fun getItemsListData() {
        mutableItems.value = itemRepository.getItems()
    }

    fun saveItemId(id: Int) {
        itemRepository.saveData(id)
    }
}