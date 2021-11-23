package com.natife.example.project1.base

interface UseCase<State, Action> {

    fun execute(state: State, action: Action): Action

    fun canHandle(action: Action): Boolean

}