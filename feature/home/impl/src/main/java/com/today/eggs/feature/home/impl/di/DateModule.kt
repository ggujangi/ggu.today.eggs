package com.today.eggs.feature.home.impl.di

import com.today.eggs.feature.home.impl.DateProvider
import com.today.eggs.feature.home.impl.DefaultDateProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DateModule {

    @Binds
    @Singleton
    abstract fun bindDateProvider(
        defaultDateProvider: DefaultDateProvider
    ): DateProvider
}