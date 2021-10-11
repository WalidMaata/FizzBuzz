package com.fizzbuzz.app.presentation.statistics

import androidx.lifecycle.*
import com.fizzbuzz.app.data.model.FizzBuzz
import com.fizzbuzz.app.domain.GetMostFrequentFizzBuzzFormUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    private val getMostFrequentFizzBuzzFormUseCase: GetMostFrequentFizzBuzzFormUseCase
) : ViewModel() {

    val mostFrequentFizzBuzz =MutableLiveData<FizzBuzz>()

    init {
        observeMostFrequentFizzBuzzForm()
    }

    private fun observeMostFrequentFizzBuzzForm() {
        viewModelScope.launch {
            getMostFrequentFizzBuzzFormUseCase().collect {
                mostFrequentFizzBuzz.value = it
            }
        }
    }

}