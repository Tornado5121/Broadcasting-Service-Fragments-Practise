package com.natife.example.project1.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<State, Action>(
    private val reducer: Reducer<State, Action>,
    private val useCases: List<UseCase<State, Action>>
) : ViewModel() {

    private val mutableState = MutableLiveData(reducer.initialState)
    val state: LiveData<State> = mutableState

    protected fun action(action: Action) {
        val currentState = mutableState.value ?: return
        val newState = reducer.reduce(currentState, action)
        mutableState.value = newState
        useCases.filter { it.canHandle(action) }.forEach {
            val result = it.execute(newState, action)
            action(result)
        }
    }
}