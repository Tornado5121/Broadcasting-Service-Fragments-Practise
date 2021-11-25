package com.natife.example.project1.ui.itemListScreen

import com.natife.example.project1.base.BaseViewModel
import com.natife.example.project1.base.UseCase

class ItemListViewModel(
    itemReducer: ItemListReducer,
    useCase: List<UseCase<MyItemsStates, MyItemsActions>>
) : BaseViewModel<MyItemsStates, MyItemsActions>(
    itemReducer,
    useCase
) {
    fun displayItemList() {
        action(MyItemsActions.GetItems)
    }

    fun saveIdItemToSharedPrefs(id: Int) {
        action(MyItemsActions.Save(id))
    }
}