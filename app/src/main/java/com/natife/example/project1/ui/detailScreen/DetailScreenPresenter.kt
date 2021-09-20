package com.natife.example.project1.ui.detailScreen

import android.content.Context
import com.natife.example.project1.base.BasePresenter
import com.natife.example.project1.base.ModelInterface
import com.natife.example.project1.models.ItemModels

class DetailScreenPresenter(context: Context) : BasePresenter<DetailedView>() {

    private val itemModel: ModelInterface = ItemModels(context)

    fun getDetailedItem(id: Int) {
        val item = itemModel.getDetailedItem(id)
        view?.showDetailedItem(item)
    }
}