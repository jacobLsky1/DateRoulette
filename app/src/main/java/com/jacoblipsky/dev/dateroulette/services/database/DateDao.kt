package com.jacoblipsky.dev.dateroulette.services.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jacoblipsky.dev.dateroulette.models.Date

@Dao
interface  DateDao {
    @Insert
    fun insert(date: Date)

    @Query("SELECT * FROM dates")
    fun getAllDates(): List<Date>

}