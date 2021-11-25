package com.natife.example.project1.ui.itemListScreen

import com.natife.example.project1.base.UseCase
import com.natife.example.project1.models.Item
import com.natife.example.project1.util.ItemsHolder

class DisplayItemListUseCase : UseCase<MyItemsStates, MyItemsActions> {

    override fun execute(state: MyItemsStates, action: MyItemsActions): MyItemsActions {
        return if (action is MyItemsActions.GetItems) {
            MyItemsActions.ItemsLoaded(createItems())
        } else {
            MyItemsActions.None
        }
    }

    override fun canHandle(action: MyItemsActions): Boolean {
        return action is MyItemsActions.GetItems
    }

    fun createItems(): List<Item> {
        return ItemsHolder.items
    }
}


