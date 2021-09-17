package com.natife.example.project1.models

import android.content.Context
import android.content.SharedPreferences
import com.natife.example.project1.base.ModelInterface
import com.natife.example.project1.models.Item
import com.natife.example.project1.ui.adapters.ItemAdapter
import com.natife.example.project1.util.ItemsHolder
import java.lang.reflect.Array.getInt

class ItemModels(context: Context) : ModelInterface {

    val SHARED_PREF_FILE_NAME = "SharedPrefs"
    val sharedPref: SharedPreferences =
        context.getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)
    val ID_KEY = "id"

    override fun saveData(id: Int) {
        val editor = sharedPref.edit()
        editor.putInt(ID_KEY, id)
        editor.apply()
    }

    override fun getData(id: Int, context: Context): Int {
        return sharedPref.getInt("id", id)
    }

    fun getItems(): List<Item> {
        return ItemsHolder.items
    }
}