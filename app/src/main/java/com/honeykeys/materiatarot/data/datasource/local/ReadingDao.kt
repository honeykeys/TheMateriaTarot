package com.honeykeys.materiatarot.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ReadingDao {
    @Query("SELECT readingId FROM reading")
    fun getReadingIds(): List<Int>
    @Query("SELECT date FROM reading")
    fun getReadingDates(): List<String>

    @Query("SELECT deck FROM reading WHERE readingId = :readingId")
    fun getReadingDeck(readingId: Int): String

    @Query("SELECT positionmap FROM reading WHERE readingId =:readingId")
    fun getPositionMap(readingId: Int): String
    @Insert
    fun insertReading(reading: Reading)
}





