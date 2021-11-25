package com.natife.example.project1.ui.detailedScreen

import com.natife.example.project1.base.Reducer

class DetailedScreenReducer(id: Int) : Reducer<DetailedScreenStates, DetailedScreenActions> {

    override val initialState: DetailedScreenStates = DetailedScreenStates(
        itemID = id,
        item = null
    )

    override fun reduce(
        state: DetailedScreenStates,
        action: DetailedScreenActions
    ): DetailedScreenStates {
        return when (action) {
            DetailedScreenActions.DisplayDetailed -> state
            DetailedScreenActions.None -> state
            is DetailedScreenActions.ItemDisplayed -> state.copy(item = action.item)
            is DetailedScreenActions.Error -> state

        }
    }
}