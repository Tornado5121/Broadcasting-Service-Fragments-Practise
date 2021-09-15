package com.natife.example.project1.presenters

import android.content.Context
import com.natife.example.project1.ItemModels
import com.natife.example.project1.ui.DetailedFragment
import com.natife.example.project1.ui.ItemListFragment

class ItemPresenter(itemModel: ItemModels, context: Context) {

    val itemModel = ItemModels(context)

    fun saveIdToSharedPrefs(id:Int) {
        itemModel.saveData(id)
    }

}