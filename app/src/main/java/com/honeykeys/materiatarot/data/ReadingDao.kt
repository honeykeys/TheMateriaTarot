package com.honeykeys.materiatarot.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ReadingDao {
    @Query("SELECT readingId FROM reading")
    fun getAllReadings(): Flow<List<Long>>
    @Query("SELECT * FROM reading WHERE readingId = :readingId")
    fun getReadingById(readingId: Long): Reading
    @Insert
    fun insertReading(reading: Reading)

}





