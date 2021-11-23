package com.natife.example.project1.ui.itemListScreen

import com.natife.example.project1.base.Reducer

class ItemListReducer : Reducer<MyItemsStates, MyItemsActions> {
    override val initialState: MyItemsStates = MyItemsStates(itemListDisplayed = listOf())

    override fun reduce(state: MyItemsStates, action: MyItemsActions): MyItemsStates {
        return when (action) {
            MyItemsActions.None -> state
            MyItemsActions.GetItems -> state
            is MyItemsActions.ItemsLoaded -> state.copy(itemListDisplayed = action.items)
        }
    }
}