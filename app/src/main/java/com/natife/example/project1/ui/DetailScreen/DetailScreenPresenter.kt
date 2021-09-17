package com.natife.example.project1.ui.DetailScreen

import android.content.Context
import android.view.View
import com.natife.example.project1.base.BasePresenter
import com.natife.example.project1.models.ItemModels
import com.natife.example.project1.ui.ItemListScreen.ItemListFragment

class DetailScreenPresenter(context: Context) : BasePresenter<DetailedFragment>() {

    val id = 2
    private val itemModel: ItemModels = ItemModels(context)
    private val detailedFragment: DetailedFragment = DetailedFragment()

    fun showDetailedView(context: Context) {
        itemModel.getData(id, context)
        detailedFragment.showDetailedInfo()
    }
}