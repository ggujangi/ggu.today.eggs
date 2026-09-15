package com.today.eggs

import androidx.lifecycle.ViewModel
import androidx.window.core.layout.WindowSizeClass


class MainViewModel : ViewModel() {

}

data class TodayEggsUIState(
    val windowSize: WindowSizeClass
)