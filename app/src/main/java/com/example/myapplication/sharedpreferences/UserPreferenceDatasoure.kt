package com.example.myapplication.sharedpreferences

interface UserPreferenceDataSource {
    fun getUserName() : String?
    fun setUserName(newAppKey:String)
    fun getOtherUserName() : String?
    fun setOtherUserName(newAppKey:String)
}
class UserPreferenceDataSourceImpl(
    private val userPreference: UserPreference
) : UserPreferenceDataSource {
    override fun getUserName(): String? {
        return userPreference.keyuser
    }
    override fun setUserName(newUserName: String) {
        userPreference.keyuser = newUserName
    }
    override fun getOtherUserName(): String? {
        return userPreference.otherusername
    }
    override fun setOtherUserName(newUserName: String) {
        userPreference.otherusername = newUserName
    }
}