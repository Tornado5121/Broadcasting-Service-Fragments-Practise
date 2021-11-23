package com.natife.example.project1.ui.detailedScreen

import com.natife.example.project1.models.Item
import com.natife.example.project1.ui.itemListScreen.MyItemsActions

sealed class DetailedScreenActions {
    object None : DetailedScreenActions()
    object DisplayDetailed : DetailedScreenActions()
    data class ItemDisplayed(val id: Int) : DetailedScreenActions()
}