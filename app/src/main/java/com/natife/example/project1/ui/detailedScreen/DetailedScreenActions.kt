package com.natife.example.project1.ui.detailedScreen

import com.natife.example.project1.models.Item

sealed class DetailedScreenActions {
    object None : DetailedScreenActions()
    object DisplayDetailed : DetailedScreenActions()
    data class ItemDisplayed(val item: Item) : DetailedScreenActions()
    data class Error(val error: Exception) : DetailedScreenActions()
}