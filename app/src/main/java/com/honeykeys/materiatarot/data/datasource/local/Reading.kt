package com.honeykeys.materiatarot.data.datasource.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.honeykeys.materiatarot.data.converters.IntegerListTypeConverter
import com.honeykeys.materiatarot.data.converters.IntegerMapTypeConverter
import com.honeykeys.materiatarot.data.converters.LocalDateConverters
import java.time.LocalDate

@Entity (tableName = "reading")
data class Reading(

    @PrimaryKey(autoGenerate = true)
    val readingId: Int = 0,

    @ColumnInfo(name = "date")
    @TypeConverters(LocalDateConverters::class)
    val readingDate: LocalDate,

    @ColumnInfo(name = "deck")
    @TypeConverters(IntegerListTypeConverter::class)
    val readingDeck: String,

    @ColumnInfo(name = "positionmap")
    @TypeConverters(IntegerMapTypeConverter::class)
    val positionMap: Map<Int, Boolean>
    )

