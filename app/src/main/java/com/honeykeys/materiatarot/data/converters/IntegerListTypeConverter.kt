package com.honeykeys.materiatarot.data.converters

import androidx.room.TypeConverter

class IntegerListTypeConverter {
        @TypeConverter
        fun fromListOfIntegersToString(integers: List<Int>): String =
            integers.joinToString(",")
        @TypeConverter
        fun fromStringToListOfIntegers(string: String): List<Int> =
            string.split(",").map {it.toInt()}
}