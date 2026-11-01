package com.today.eggs.feature.home.impl

import kotlinx.datetime.LocalDate

data class HomeUiState(
    val currentDate: LocalDate,
    val canGoPrevious: Boolean = true,
    val canGoNext: Boolean = false,
)