package com.fizzbuzz.app.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.fizzbuzz.app.MainCoroutineRule
import com.fizzbuzz.app.data.database.FizzBuzzDatabase
import com.fizzbuzz.app.data.model.FizzBuzz
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.*
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class FizzBuzzDaoTest {

    private lateinit var database: FizzBuzzDatabase

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun initDb() {
        // using an in-memory database because the information stored here disappears when the
        // process is killed
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            FizzBuzzDatabase::class.java
        ).allowMainThreadQueries().build()
    }

    @After
    fun closeDb() = database.close()


    @Test
    fun insertAndGet() = runBlockingTest {

        //given
        val fizzBuzz = FizzBuzz(3,5,100,"fizz","buzz")
        database.fizzBuzzDao().insert(fizzBuzz)


        //when - get inserted fizzbuzz
        val result = database.fizzBuzzDao().getMostFrequentFizzBuzz().first()

        //then
        assertEquals(result.firstInteger, fizzBuzz.firstInteger)
        assertEquals(result.secondInteger, fizzBuzz.secondInteger)
        assertEquals(result.limit, fizzBuzz.limit)
        assertEquals(result.firstString, fizzBuzz.firstString)
        assertEquals(result.secondString, fizzBuzz.secondString)
    }

    @Test
    fun incrementNumberOfHit() = runBlockingTest {
        //given
        val fizzBuzz = FizzBuzz(3,5,100,"fizz","buzz")
        database.fizzBuzzDao().insert(fizzBuzz)
        database.fizzBuzzDao().increment(fizzBuzz.id)

        //when - get inserted fizzbuzz
        val result = database.fizzBuzzDao().getMostFrequentFizzBuzz().first()

        //then
        assertEquals(result.count, 2)
    }

}
