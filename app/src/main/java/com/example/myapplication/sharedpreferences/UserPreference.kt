package com.example.myapplication.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class UserPreference(context: Context) {
    private val preference : SharedPreferences = context.getSharedPreferences(NAME, MODE)

    companion object{
        private const val NAME = "username"
        private const val MODE = Context.MODE_PRIVATE
    }
    var keyuser: String?
        get() = preference.getString(
            PreferenceKey.PREF_USER_APP_KEY.first,
            PreferenceKey.PREF_USER_APP_KEY.second
        )
        set(value) = preference.edit {
            this.putString(PreferenceKey.PREF_USER_APP_KEY.first,value)
        }
    var otherusername :String?
        get() = preference.getString(
            PreferenceKey.PREF_USER_APP_OTHER.first,
            PreferenceKey.PREF_USER_APP_OTHER.second
        )
        set(value) = preference.edit {
            this.putString(PreferenceKey.PREF_USER_APP_OTHER.first,value)
        }
}

object PreferenceKey{
    val PREF_USER_APP_KEY = Pair("PREF_USER_APP_KEY",null)
    val PREF_USER_APP_OTHER = Pair("PREF_USER_APP_OTHER",null)
}