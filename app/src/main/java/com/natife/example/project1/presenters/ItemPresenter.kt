package com.natife.example.project1.presenters

import android.content.Context
import com.natife.example.project1.ItemModels
import com.natife.example.project1.models.Item
import com.natife.example.project1.ui.DetailedFragment
import com.natife.example.project1.ui.ItemListFragment
import com.natife.example.project1.ui.adapters.ItemAdapter

class ItemPresenter(itemModel: ItemModels, context: Context) {

    val itemModel = ItemModels(context)

    fun saveIdToSharedPrefs(id:Int) {
        itemModel.saveData(id)
    }

    fun getListItems():List<Item> {
       return itemModel.submitListToAdapter()
    }

}