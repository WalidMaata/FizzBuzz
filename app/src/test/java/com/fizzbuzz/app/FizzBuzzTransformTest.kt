package com.fizzbuzz.app

import com.fizzbuzz.app.commun.transform
import com.fizzbuzz.app.data.model.FizzBuzz
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class FizzBuzzTransformTest(
    private val fizzBuzz: FizzBuzz,
    private val expected: List<String>
) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf(FizzBuzz(2, 9 , 9, "odd", "limit"), listOf("1","odd","3","odd","5","odd","7","odd","limit")),
            arrayOf(FizzBuzz(3, 5 , 15, "fizz", "buzz"), listOf("1","2","fizz","4","buzz","fizz","7","8","fizz","buzz","11","fizz","13","14","fizzbuzz")),
        )
    }

    @Test
    fun test() {
        val result = (1..fizzBuzz.limit).map { fizzBuzz.transform(it) }
        assertEquals(expected, result)
    }

}