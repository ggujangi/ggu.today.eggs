package com.today.eggs.feature.home.impl

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn
import javax.inject.Inject

interface DateProvider {
    fun getToday() : LocalDate
}

class DefaultDateProvider @Inject constructor() : DateProvider {
    override fun getToday(): LocalDate {
        return Clock.System.todayIn(TimeZone.currentSystemDefault())
    }
}