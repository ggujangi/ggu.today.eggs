package com.today.eggs.feature.home.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.LocalDate
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    dateProvider: DateProvider,
) : ViewModel() {

    val minDate = dateProvider.getMinDate()
    val maxDate = dateProvider.getMaxDate()

    private val _selectedDate = MutableStateFlow(dateProvider.getToday())

    @OptIn(ExperimentalCoroutinesApi::class)
    val uiState: StateFlow<HomeUiState> = _selectedDate
        .flatMapLatest { date ->
            flow {
                emit(
                    HomeUiState(
                        currentDate = date,
                        canGoPrevious = date > minDate,
                        canGoNext = date < maxDate,
                    )
                )
            }

        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeUiState(
                currentDate = dateProvider.getToday(),
                canGoPrevious = true,
                canGoNext = false,
            )
        )

    fun moveToPreviousDay() {
        if (_selectedDate.value > minDate) {
            _selectedDate.update { it.minus(DatePeriod(days = 1)) }
        }
    }

    fun moveToNextDay() {
        if (_selectedDate.value < maxDate) {
            _selectedDate.update { it.plus(DatePeriod(days = 1)) }
        }
    }

    fun onDateSelected(date: LocalDate) {
        if (date in minDate..maxDate) {
            _selectedDate.value = date
        }
    }
}
