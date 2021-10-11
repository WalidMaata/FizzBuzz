package com.fizzbuzz.app.commun

import com.fizzbuzz.app.data.model.FizzBuzz

fun FizzBuzz.transform(index: Int): String {
    return when {
        index % firstInteger == 0 && index % secondInteger == 0 -> firstString + secondString
        index % firstInteger == 0 -> firstString
        index % secondInteger == 0 -> secondString
        else -> index.toString()
    }
}