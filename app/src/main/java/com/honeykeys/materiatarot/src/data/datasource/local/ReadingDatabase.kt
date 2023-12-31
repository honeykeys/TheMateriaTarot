package com.honeykeys.materiatarot.src.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.honeykeys.materiatarot.src.data.converters.TarotCardsTypeConverter

@Database(entities = [SavedReading::class], version = 1, exportSchema = false)
@TypeConverters(TarotCardsTypeConverter::class)
abstract class ReadingDatabase: RoomDatabase() {
    abstract fun readingDao(): ReadingDao
}
