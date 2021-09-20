package com.natife.example.project1.ui.detailScreen

import android.content.Context
import com.natife.example.project1.base.BasePresenter
import com.natife.example.project1.models.ItemModels

class DetailScreenPresenter(context: Context) : BasePresenter<DetailedView>() {

    private val itemModel: ItemModels = ItemModels(context)

    fun getDetailedItem() {
        val item = itemModel.getDetailedItem()
        view?.showDetailedItem(item)
    }
}