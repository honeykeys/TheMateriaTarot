package com.honeykeys.materiatarot.data

import android.app.Application
import androidx.room.Database
import androidx.room.RoomDatabase
import dagger.hilt.android.HiltAndroidApp

@Database(entities = [Reading::class], version = 1)
abstract class ReadingDatabase: RoomDatabase() {
    abstract fun readingDao(): ReadingDao
}

@HiltAndroidApp
class MateriaTarotApp: Application()