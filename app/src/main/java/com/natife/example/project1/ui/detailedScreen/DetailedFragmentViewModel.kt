package com.natife.example.project1.ui.detailedScreen

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natife.example.project1.models.ItemRepository
import com.natife.example.project1.models.Item

class DetailedFragmentViewModel(context: Context) : ViewModel() {
    private val itemRepository = ItemRepository(context)
    private val detailedItem = MutableLiveData<Item>()
    val detailedItemToAttach: LiveData<Item> = detailedItem

    fun getDetailedItem(id:Int) {
        detailedItem.value = itemRepository.getDetailedItem(id)
    }
}