package com.natife.example.project1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import com.natife.example.project1.ui.DetailedFragment

class ItemModels(context: Context) {

    val SHARED_PREF_FILE_NAME = "SharedPrefs"
    val sharedPref: SharedPreferences = context.getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)
    val ID_KEY = "id"

    fun saveData(id: Int): SharedPreferences {
        val editor = sharedPref.edit()
        editor.putInt(ID_KEY, id)
        editor.apply()
        return sharedPref
    }
}