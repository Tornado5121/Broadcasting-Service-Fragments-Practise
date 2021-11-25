package com.natife.example.project1.ui.itemListScreen

import com.natife.example.project1.models.Item

sealed class MyItemsActions {
    object None : MyItemsActions()
    object GetItems : MyItemsActions()
    data class ItemsLoaded(val items: List<Item>) : MyItemsActions()
    data class Error(val error: Exception) : MyItemsActions()
}

