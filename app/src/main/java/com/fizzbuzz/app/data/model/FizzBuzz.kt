package com.fizzbuzz.app.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "fizzbuzz")
data class FizzBuzz @JvmOverloads constructor(
    val firstInteger: Int,
    val secondInteger: Int,
    val limit: Int,
    val firstString: String,
    val secondString: String,
    var count: Int = 1,
    @PrimaryKey val id: String = firstInteger.toString() + secondInteger.toString() + limit.toString() + firstString + secondString
) : Parcelable