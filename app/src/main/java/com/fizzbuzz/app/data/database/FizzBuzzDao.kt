package com.fizzbuzz.app.data.database

import androidx.room.*
import com.fizzbuzz.app.data.model.FizzBuzz
import kotlinx.coroutines.flow.Flow

@Dao
interface FizzBuzzDao {

    /**
     * Insert a fizzBuzz object in database . If fizzBuzz already exist replace it
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(fizzBuzz: FizzBuzz)

    /**
     * Get item by id
     */
    @Query("SELECT * FROM fizzbuzz WHERE id=:id LIMIT 1")
    suspend fun getFizzBuzzById(id: String) : FizzBuzz?

    /**
     * Increment number of hit
     */
    @Query("UPDATE fizzbuzz SET count = count + 1 WHERE id=:id")
    suspend fun increment(id: String)

    /**
     *
     */
    @Query("SELECT * FROM fizzbuzz ORDER BY count DESC LIMIT 1")
    fun getMostFrequentFizzBuzz(): Flow<FizzBuzz>

}