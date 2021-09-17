package com.natife.example.project1.ui.ItemListScreen

import com.natife.example.project1.models.Item


interface ItemListView {

    fun showItems(items: List<Item>)

}