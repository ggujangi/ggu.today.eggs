package com.today.eggs.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.today.eggs.R
import com.today.eggs.feature.calendar.api.CalendarRoute
import com.today.eggs.feature.home.api.HomeRoute
import kotlin.reflect.KClass

enum class MainTab(
    val titleRes: Int,
    val icon: ImageVector,
    val route: KClass<out Any>,
    val routeInstance: Any
) {
    HOME(R.string.title_home, Icons.Default.Home, HomeRoute::class, HomeRoute),
    CALENDAR(R.string.title_calendar, Icons.Default.CalendarMonth, CalendarRoute::class, CalendarRoute)
}