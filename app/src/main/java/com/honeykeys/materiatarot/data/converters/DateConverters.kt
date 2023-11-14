package com.honeykeys.materiatarot.data.converters

import androidx.room.TypeConverter
import java.time.LocalDate
import java.util.Date

class DateConverters {
    @TypeConverter
    fun fromLocalDate(date: LocalDate?): String? {
        return date?.toString()
    }
    @TypeConverter
    fun toLocalDate(dateString: String?): LocalDate? {
        return dateString?.let {LocalDate.parse(it)}
    }

}