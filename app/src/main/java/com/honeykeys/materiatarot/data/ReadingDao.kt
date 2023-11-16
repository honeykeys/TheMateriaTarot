package com.honeykeys.materiatarot.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import java.time.LocalDate

@Dao
interface ReadingDao {
    @Query("SELECT readingId FROM reading")
    fun getReadingIds(): List<Long>
    @Query("SELECT date_column FROM reading")
    fun getReadingDates(): List<LocalDate>
    @Query("SELECT deck_column FROM reading WHERE readingId = :readingId")
    fun getReadingDeck(readingId: Long): List<Int>
    @Query("SELECT positionmap_column FROM reading WHERE readingId =:readingId")
    fun getPositionMap(readingId: Long): Map<Int, Boolean>
    @Insert
    fun insertReading(reading: Reading)
}





