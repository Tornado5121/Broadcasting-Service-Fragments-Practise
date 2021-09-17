package com.natife.example.project1.base

import android.content.Context

interface ModelInterface {

    fun getData(id:Int, context: Context) : Int
    fun saveData(id:Int)
}