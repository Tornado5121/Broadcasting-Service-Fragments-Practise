package com.natife.example.project1.ui.detailedScreen

import android.content.Context
import android.content.SharedPreferences
import com.natife.example.project1.base.UseCase
import com.natife.example.project1.ui.detailedScreen.DetailedScreenActions
import com.natife.example.project1.ui.detailedScreen.DetailedScreenStates
import com.natife.example.project1.ui.itemListScreen.MyItemsActions
import com.natife.example.project1.ui.itemListScreen.MyItemsStates

class DisplayDeatiledScreenUseCase(private val context: Context) : UseCase<DetailedScreenStates, DetailedScreenActions> {

    val SHARED_PREF_FILE_NAME = "SharedPrefs"
    val sharedPref: SharedPreferences = context.getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)
    val ID_KEY = "id"

    override fun execute(state: DetailedScreenStates, action: DetailedScreenActions): DetailedScreenActions {
//        if (action is DetailedScreenActions.DisplayDetailed) {
////            return DetailedScreenActions.ItemDisplayed()
//        } else {
            return DetailedScreenActions.None
//        }
    }


    override fun canHandle(action: DetailedScreenActions): Boolean {
        return action is DetailedScreenActions.ItemDisplayed
    }

    fun saveData(id: Int): SharedPreferences {
        val editor = sharedPref.edit()
        editor.putInt(ID_KEY, id)
        editor.apply()
        return sharedPref
    }
}

