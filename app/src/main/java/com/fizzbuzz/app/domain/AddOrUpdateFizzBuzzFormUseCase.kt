package com.fizzbuzz.app.domain

import com.fizzbuzz.app.data.model.FizzBuzz
import com.fizzbuzz.app.data.repositories.FizzBuzzRepository
import javax.inject.Inject

class AddOrUpdateFizzBuzzFormUseCase @Inject constructor(
    private val fizzBuzzRepository: FizzBuzzRepository
) {
    suspend operator fun invoke(fizzBuzz: FizzBuzz) = fizzBuzzRepository.addOrUpdate(fizzBuzz)
}