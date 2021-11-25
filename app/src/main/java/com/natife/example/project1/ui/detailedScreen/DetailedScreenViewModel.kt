package com.natife.example.project1.ui.detailedScreen

import com.natife.example.project1.base.BaseViewModel

class DetailedScreenViewModel(
    reducer: DetailedScreenReducer,
    useCase: DisplayDeatiledScreenUseCase
) : BaseViewModel<DetailedScreenStates, DetailedScreenActions>(reducer, listOf(useCase)) {

    fun getData() {
        action(DetailedScreenActions.DisplayDetailed)
    }
}