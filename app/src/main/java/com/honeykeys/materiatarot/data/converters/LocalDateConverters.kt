package com.honeykeys.materiatarot.data.converters

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalDate.parse
import java.time.format.DateTimeFormatter

class LocalDateConverters {

    private val dateFormatter: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE
    @TypeConverter
    fun fromLocalDate(date: LocalDate): String =
        date.format(dateFormatter)
    @TypeConverter
    fun toLocalDate(dateString: String): LocalDate =
        dateString.let { parse(it, dateFormatter) }
}