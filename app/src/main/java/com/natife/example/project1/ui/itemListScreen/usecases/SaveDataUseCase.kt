package com.natife.example.project1.ui.itemListScreen.usecases

import android.content.Context
import android.content.SharedPreferences
import com.natife.example.project1.base.UseCase
import com.natife.example.project1.ui.itemListScreen.MyItemsActions
import com.natife.example.project1.ui.itemListScreen.MyItemsStates

private val ID_KEY = "id"
private val SHARED_PREF_FILE_NAME = "SharedPrefs"

class SaveDataUseCase(val context: Context) : UseCase<MyItemsStates, MyItemsActions> {

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(SHARED_PREF_FILE_NAME, Context.MODE_PRIVATE)

    override fun execute(state: MyItemsStates, action: MyItemsActions): MyItemsActions {
        return if (action is MyItemsActions.Save) {
            MyItemsActions.DataSaved(saveData(action.id).getInt(ID_KEY, 1))
        } else {
            MyItemsActions.None
        }
    }

    override fun canHandle(action: MyItemsActions): Boolean {
        return action is MyItemsActions.Save
    }

    private fun saveData(id: Int): SharedPreferences {
        val editor = sharedPref.edit()
        editor.putInt(ID_KEY, id)
        editor.apply()
        return sharedPref
    }
}