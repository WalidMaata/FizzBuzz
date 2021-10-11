package com.fizzbuzz.app.data.repositories

import com.fizzbuzz.app.data.database.FizzBuzzDao
import com.fizzbuzz.app.data.model.FizzBuzz
import kotlinx.coroutines.flow.Flow

class FizzBuzzRepositoryImplem(
    private val fizzBuzzDao: FizzBuzzDao
) : FizzBuzzRepository {

    override suspend fun addOrUpdate(fizzBuzz: FizzBuzz) {
        if (fizzBuzzDao.getFizzBuzzById(fizzBuzz.id) == null) {
            fizzBuzzDao.insert(fizzBuzz)
        } else {
            fizzBuzzDao.increment(fizzBuzz.id)
        }
    }

    override fun getMostFrequentFizzBuzz(): Flow<FizzBuzz?> {
        return fizzBuzzDao.getMostFrequentFizzBuzz()
    }
}