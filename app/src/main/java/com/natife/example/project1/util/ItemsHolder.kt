package com.natife.example.project1.util

import com.natife.example.project1.models.Item

object ItemsHolder {

    val items = (0 until 19).map {
        createItem(it)
    }

    fun getById(id: Int): Item {
        return Item(id)
    }

    private fun createItem(id: Int): Item {
        return Item(id)
    }

}