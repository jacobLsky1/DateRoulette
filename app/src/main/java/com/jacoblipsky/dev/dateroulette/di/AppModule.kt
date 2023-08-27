package com.jacoblipsky.dev.dateroulette.di

import android.content.Context
import androidx.room.Room
import com.jacoblipsky.dev.dateroulette.services.database.DateDao
import com.jacoblipsky.dev.dateroulette.services.database.DateDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getContext( @ApplicationContext context: Context) = context

    @Provides
    @Singleton
    fun provideDatabase(context: Context): DateDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            DateDatabase::class.java, "database"
        ).build()
    }

    @Provides
    fun provideUserDao(database: DateDatabase): DateDao {
        return database.dateDao()
    }
}