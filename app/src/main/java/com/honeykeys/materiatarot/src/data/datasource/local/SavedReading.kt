package com.honeykeys.materiatarot.src.data.datasource.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.honeykeys.materiatarot.src.data.converters.TarotCardsTypeConverter
import com.honeykeys.materiatarot.src.data.model.TarotCard

@Entity (tableName = "reading")
data class SavedReading(

    @PrimaryKey(autoGenerate = true)
    val readingId: Int? = null,

    @ColumnInfo(name = "readingCards")
    @TypeConverters(TarotCardsTypeConverter::class)
    val readingDeck: List<TarotCard>,

    @ColumnInfo(name = "readingLayout")
    val readingLayout: String,

    @ColumnInfo(name = "readingQuestion")
    val readingQuestion: String
)

