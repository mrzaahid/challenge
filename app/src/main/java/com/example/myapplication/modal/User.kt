package com.example.myapplication.modal

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id:String?,
    @SerializedName("email")
    val email:String?,
    @SerializedName("firstname")
    val firstname:String?,
    @SerializedName("lastname")
    val lastname:String?,
    @SerializedName("avatar")
    val avatar:String?
)