package com.jacoblipsky.dev.dateroulette.di

import com.jacoblipsky.dev.dateroulette.services.database.DateDao
import com.jacoblipsky.dev.dateroulette.services.repositories.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideMainRepository(dateDao: DateDao): MainRepository {
        return MainRepository(dateDao)
    }
}