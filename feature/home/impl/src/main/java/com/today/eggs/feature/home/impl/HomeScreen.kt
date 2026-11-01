package com.today.eggs.feature.home.impl

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.today.eggs.feature.home.impl.ui.DateHeader
import com.today.eggs.feature.home.impl.ui.HomeDatePickerDialog

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val homeUiState by viewModel.uiState.collectAsStateWithLifecycle()
    var showDatePicker by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        DateHeader(
            date = homeUiState.currentDate,
            canGoPrevious = homeUiState.canGoPrevious,
            canGoNext = homeUiState.canGoNext,
            goToPreviousDay = { viewModel.moveToPreviousDay() },
            goToNextDay = { viewModel.moveToNextDay() },
            onTextClick = { showDatePicker = true }
        )
    }

    if (showDatePicker) {
        HomeDatePickerDialog(
            currentDate = homeUiState.currentDate,
            minDate = viewModel.minDate,
            maxDate = viewModel.maxDate,
            onDateSelected = { selectedDate ->
                viewModel.onDateSelected(selectedDate)
                showDatePicker = false
            },
            onDismiss = { showDatePicker = false }
        )
    }
}
