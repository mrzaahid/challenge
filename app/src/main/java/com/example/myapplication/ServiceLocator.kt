package com.example.myapplication

import android.content.Context
import com.example.myapplication.sharedpreferences.UserPreference
import com.example.myapplication.sharedpreferences.UserPreferenceDataSource
import com.example.myapplication.sharedpreferences.UserPreferenceDataSourceImpl

object ServiceLocator {
    fun provideUserPreference(context: Context): UserPreference {
        return UserPreference(context)
    }

    fun provideUserPreferenceDataSource(context: Context): UserPreferenceDataSource {
        return UserPreferenceDataSourceImpl(provideUserPreference(context))
    }

}