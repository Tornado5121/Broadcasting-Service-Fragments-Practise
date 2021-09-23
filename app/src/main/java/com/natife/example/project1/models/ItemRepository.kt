package com.natife.example.project1.models

import android.content.Context
import android.content.SharedPreferences
import com.natife.example.project1.models.Item
import com.natife.example.project1.util.ItemsHolder

class ItemRepository(context: Context) {

    private val SHARED_PREF_FILE_NAME = "SharedPrefs"
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)
    private val ID_KEY = "id"

    fun saveData(id: Int): SharedPreferences {
        val editor = sharedPref.edit()
        editor.putInt(ID_KEY, id)
        editor.apply()
        return sharedPref
    }

    fun getItems(): List<Item> {
        return ItemsHolder.items
    }

    fun getDetailedItem(id:Int) : Item{
        return ItemsHolder.getById(id)
    }
}