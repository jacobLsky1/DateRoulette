package com.jacoblipsky.dev.dateroulette.services.repositories

import com.jacoblipsky.dev.dateroulette.models.Date
import com.jacoblipsky.dev.dateroulette.services.database.DateDao


class MainRepository(val dateDao: DateDao) {
    fun insertDate(date: Date) {
        dateDao.insert(date)
    }

    fun getAllDates(): List<Date> {
        return dateDao.getAllDates()
    }

}
