package com.natife.example.project1.ui.itemListScreen

import com.natife.example.project1.models.Item


interface ItemListView {

    fun showItems(items: List<Item>)

}