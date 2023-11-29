package com.honeykeys.materiatarot.data.converters

import androidx.room.TypeConverter
import java.time.LocalDate

class LocalDateListConverter {
    @TypeConverter
    fun fromString(value: String?): List<LocalDate>? {
        if (value == null) {
            return emptyList()
        }
        val dates = value.split(",").map { LocalDate.parse(it) }
        return dates
    }

    @TypeConverter
    fun toString(dates: List<LocalDate>?): String {
        if (dates.isNullOrEmpty()) {
            return ""
        }
        return dates.joinToString(",") { it.toString() }
    }
}