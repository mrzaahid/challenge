package com.example.myapplication

import androidx.lifecycle.ViewModel
import com.example.myapplication.modal.UserResponse
import com.example.myapplication.sharedpreferences.UserPreference
import com.example.myapplication.sharedpreferences.UserPreferenceDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val userPreferenceDataSource: UserPreferenceDataSource):ViewModel() {
    fun setUsername(string: String){
        userPreferenceDataSource.setUserName(string)
    }
    fun getUsername():String?{
        return userPreferenceDataSource.getUserName()
    }
    fun setOtherUsername(string: String){
        userPreferenceDataSource.setOtherUserName(string)
    }
    fun getOtherUsername():String?{
        return userPreferenceDataSource.getOtherUserName()
    }
    fun getUsers(page:Int,perPage:Int):UserResponse?{
        var x :UserResponse? = null
        ApiClient.instance.getUsers(page,perPage).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val body = response.body()
                val code =response.code()
                x = response.body()

            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                x = null
            }

        })
        return x
    }
}