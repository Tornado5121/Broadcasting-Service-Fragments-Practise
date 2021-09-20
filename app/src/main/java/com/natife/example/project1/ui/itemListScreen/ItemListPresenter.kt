package com.natife.example.project1.ui.itemListScreen

import android.content.Context
import com.natife.example.project1.base.BasePresenter
import com.natife.example.project1.models.ItemModels

class ItemListPresenter(context: Context) : BasePresenter<ItemListView>() {

    private val itemModel: ItemModels = ItemModels(context)

    fun saveIdToSharedPrefs(id: Int) {
        itemModel.saveData(id)
    }

    fun getItems() {
        val items = itemModel.getItems()
        view?.showItems(items)
    }
}