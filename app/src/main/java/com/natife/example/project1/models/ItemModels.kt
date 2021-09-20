package com.natife.example.project1.models

import android.content.Context
import android.content.SharedPreferences
import com.natife.example.project1.base.ModelInterface
import com.natife.example.project1.util.ItemsHolder

class ItemModels(context: Context) : ModelInterface {

    private val SHARED_PREF_FILE_NAME = "sharedPrefs"
    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)
    private val ID_KEY = "id"

    // prepare data for DetailedFragment
    override fun getDetailedItem(id: Int): Item {
        return ItemsHolder.getById(getItemId())
    }

    override fun getItemId(): Int {
        return sharedPref.getInt("id", -1)
    }

    // prepare data for ItemListFragment
    fun getItems(): List<Item> {
        return ItemsHolder.items
    }

    override fun saveData(id: Int) {
        val editor = sharedPref.edit()
        editor.putInt(ID_KEY, id)
        editor.apply()
    }
}