package com.honeykeys.materiatarot.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.honeykeys.materiatarot.data.converters.DateConverters
import com.honeykeys.materiatarot.data.converters.JsonConverters
import java.time.LocalDate
import java.util.Date

@Entity (tableName = "reading")
@TypeConverters(DateConverters::class, JsonConverters::class)
data class Reading(
    @PrimaryKey(autoGenerate = true)
    val readingId: Long = 0,
    @ColumnInfo(name = "date_column")
    @TypeConverters(DateConverters::class)
    val readingDate: LocalDate,
    @ColumnInfo(name = "deck_column")
    @TypeConverters(JsonConverters::class)
    val readingDeck: List<TarotCard>
    )

