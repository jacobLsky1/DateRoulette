package com.jacoblipsky.dev.dateroulette.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dates")
data class Date(
    @PrimaryKey val id: String,
    var accessibilityLevel: Int,
    var accessories: Accessories?,
    var dateLocation: DateLocation,
    var name: String,
    var picture: String,
    var priceLevel: Int,
    var type: String,
    var address: String,
    var isKosher: Boolean?,
    var weatherAffectedLevel: Int
)