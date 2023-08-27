package com.jacoblipsky.dev.dateroulette.services.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jacoblipsky.dev.dateroulette.models.Date

@Database(entities = [Date::class], version = 1)
abstract class DateDatabase : RoomDatabase() {
    abstract fun dateDao(): DateDao
}