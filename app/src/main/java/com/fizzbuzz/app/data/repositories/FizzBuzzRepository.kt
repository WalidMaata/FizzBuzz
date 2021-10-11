package com.fizzbuzz.app.data.repositories

import com.fizzbuzz.app.data.model.FizzBuzz
import kotlinx.coroutines.flow.Flow

interface FizzBuzzRepository {

    suspend fun addOrUpdate(fizzBuzz: FizzBuzz)

    fun getMostFrequentFizzBuzz() : Flow<FizzBuzz?>
}