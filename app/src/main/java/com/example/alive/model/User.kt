package com.example.alive.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val fname : String,val lname:String,val age:String): Parcelable