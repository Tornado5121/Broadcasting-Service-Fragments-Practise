package com.natife.example.project1.base

import com.natife.example.project1.models.Item

interface ModelInterface {

    fun getItemId() : Int
    fun saveData(id:Int)
    fun getDetailedItem(id: Int) : Item
}