package com.natife.example.project1.base

abstract class BasePresenter<T>() {

    protected var view: T? = null

    fun attachView(viewScreen: T) {
        view = viewScreen
    }

    fun detachView() {
        view = null
    }

    fun isViewAttached(): Boolean {
        return view != null
    }

    fun destroy() {

    }
}