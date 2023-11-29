package com.honeykeys.materiatarot.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.honeykeys.materiatarot.data.converters.IntegerListTypeConverter
import com.honeykeys.materiatarot.data.converters.IntegerMapTypeConverter
import com.honeykeys.materiatarot.data.converters.LocalDateConverters

@Database(entities = [Reading::class], version = 1)
@TypeConverters(IntegerListTypeConverter::class, IntegerMapTypeConverter::class,
    LocalDateConverters::class)
abstract class ReadingDatabase: RoomDatabase() {
    abstract fun readingDao(): ReadingDao
}
