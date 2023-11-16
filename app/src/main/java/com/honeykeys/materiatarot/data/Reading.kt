package com.honeykeys.materiatarot.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.honeykeys.materiatarot.data.converters.DateConverters
import com.honeykeys.materiatarot.data.converters.IntegerListTypeConverter
import com.honeykeys.materiatarot.data.converters.IntegerMapTypeConverter
import java.time.LocalDate

@Entity (tableName = "reading")
@TypeConverters(DateConverters::class, IntegerMapTypeConverter::class)
data class Reading(

    @PrimaryKey(autoGenerate = true)
    val readingId: Long = 0,

    @ColumnInfo(name = "date_column")
    @TypeConverters(DateConverters::class)
    val readingDate: LocalDate,

    @ColumnInfo(name = "deck_column")
    @TypeConverters(IntegerListTypeConverter::class)
    val readingDeck: List<Int>,

    @ColumnInfo(name = "reverse_column")
    @TypeConverters(IntegerMapTypeConverter::class)
    val positionMap: Map<Int, Int>
    )

