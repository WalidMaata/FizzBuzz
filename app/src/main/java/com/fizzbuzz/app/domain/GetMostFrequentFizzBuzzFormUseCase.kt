package com.fizzbuzz.app.domain

import com.fizzbuzz.app.data.model.FizzBuzz
import com.fizzbuzz.app.data.repositories.FizzBuzzRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMostFrequentFizzBuzzFormUseCase @Inject constructor(
    private val fizzBuzzRepository: FizzBuzzRepository
) {
    operator fun invoke() : Flow<FizzBuzz?> = fizzBuzzRepository.getMostFrequentFizzBuzz()
}