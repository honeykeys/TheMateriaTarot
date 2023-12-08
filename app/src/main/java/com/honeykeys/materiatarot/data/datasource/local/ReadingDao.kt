package com.honeykeys.materiatarot.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface ReadingDao {
    @Query("SELECT readingId FROM reading")
    fun getReadingIds(): Flow<List<Int>>

    @Query("SELECT * FROM reading WHERE readingId = :readingId")
    suspend fun getReading(readingId: Int): SavedReading

    @Insert
    suspend fun insertReading(reading: SavedReading)
}





