package com.natife.example.project1.ui.detailedScreen

import com.natife.example.project1.base.UseCase
import com.natife.example.project1.util.ItemsHolder

class DisplayDeatiledScreenUseCase : UseCase<DetailedScreenStates, DetailedScreenActions> {

    override fun execute(
        state: DetailedScreenStates,
        action: DetailedScreenActions
    ): DetailedScreenActions {
        return if (action is DetailedScreenActions.DisplayDetailed) {
            DetailedScreenActions.ItemDisplayed(ItemsHolder.getById(state.itemID))
        } else {
            DetailedScreenActions.None
        }
    }

    override fun canHandle(action: DetailedScreenActions): Boolean {
        return action is DetailedScreenActions.DisplayDetailed
    }
}

