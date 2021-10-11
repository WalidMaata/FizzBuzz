package com.fizzbuzz.app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fizzbuzz.app.data.model.FizzBuzz

@Database(entities = [FizzBuzz::class], version = 1, exportSchema = true)
abstract class FizzBuzzDatabase : RoomDatabase() {
    abstract fun fizzBuzzDao(): FizzBuzzDao
}