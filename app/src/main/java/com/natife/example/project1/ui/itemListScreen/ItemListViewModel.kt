package com.natife.example.project1.ui.itemListScreen

import com.natife.example.project1.base.BaseViewModel

class ItemListViewModel(
    itemReducer: ItemListReducer,
    displayItemListUseCase: DisplayItemListUseCase
) : BaseViewModel<MyItemsStates, MyItemsActions>(
        itemReducer,
        listOf(displayItemListUseCase)
    ) {

    fun displayItemList() {
        action(MyItemsActions.GetItems)
    }
}