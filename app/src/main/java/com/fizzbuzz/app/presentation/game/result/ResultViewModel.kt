package com.fizzbuzz.app.presentation.game.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fizzbuzz.app.data.model.FizzBuzz
import com.fizzbuzz.app.domain.AddOrUpdateFizzBuzzFormUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val addOrUpdateFizzBuzzFormUseCase: AddOrUpdateFizzBuzzFormUseCase
) : ViewModel() {

    fun addOrUpdate(fizzBuzz: FizzBuzz) {
        viewModelScope.launch {
            addOrUpdateFizzBuzzFormUseCase(fizzBuzz)
        }
    }
}